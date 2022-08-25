package com.shonen.poc.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shonen.poc.resources.responses.Response;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public final class Utils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static final Map<String, Pair<Long, Session>> sessions = new ConcurrentHashMap<>();

    private Utils() {
        throw new IllegalStateException("This class should not have constructor!");
    }

    public static Response response(Object data) {
        return Response.builder()
                .data(data)
                .build();
    }

    public static Response response(Page<?> pagination) {
        return Response.builder()
                .data(pagination.getContent())
                .totalElements(pagination.getTotalElements())
                .pagination(pagination)
                .build();
    }

    public static String generateHash() {
        try {
            final var salt = MessageDigest.getInstance("SHA-256");
            final byte[] digest = salt.digest(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
            return DatatypeConverter.printHexBinary(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream getFile(String fileName) {
        try {
            return Objects.requireNonNull(new ClassPathResource(fileName).getInputStream());
        } catch (NullPointerException | IOException ex) {
            throw new NullPointerException("Não foi possível ler o arquivo " + fileName);
        }
    }

    public static Object getLikeQuery(Object q) {
        if (q == null) {
            q = "";
        }
        if (q.toString().isBlank()) {
            q = "";
        }

        return "%" + q + "%";
    }

    public static Object getLikeQuery(List<Object> q) {
        if (q == null || q.isEmpty()) {
            return getLikeQuery("");
        }
        if (q.size() == 1) {
            return getLikeQuery(q.get(0));
        }
        return q.stream().map(Utils::getLikeQuery).toList();
    }

    public static Sort buildSortDirection(@NonNull String sort, Sort.Direction direction) {
        if (direction == null) {
            direction = Sort.Direction.ASC;
        }

        return Sort.by(direction.equals(Sort.Direction.DESC) ? Sort.Direction.DESC : Sort.Direction.ASC, sort);
    }

    public static Sort buildSortDirection(@NonNull String sort, String propertyName, Sort.Direction direction) {
        if (direction == null) {
            direction = Sort.Direction.ASC;
        }
        if (propertyName == null) {
            return buildSortDirection(sort, direction);
        }

        return Sort.by(direction.equals(Sort.Direction.DESC) ? Sort.Direction.DESC : Sort.Direction.ASC, propertyName + "." + sort);
    }

    public static PageRequest buildPageRequest(Integer page, Integer size) {
        if (page == null || size == null) {
            return PageRequest.of(0, 9999);
        }
        return PageRequest.of(page, size);
    }

    public static PageRequest buildPageRequest(Integer page, Integer size, String sort, Sort.Direction direction) {
        if (page == null || size == null) {
            return buildPageRequest(page, size);
        }
        if (sort == null) {
            return PageRequest.of(page, size);
        }
        return PageRequest.of(page, size, buildSortDirection(sort, direction));
    }

    public static PageRequest buildPageRequest(Integer page, Integer size, String sort, String propertyName, Sort.Direction direction) {
        if (page == null || size == null) {
            return buildPageRequest(page, size);
        }
        if (sort == null) {
            return PageRequest.of(page, size);
        }
        return PageRequest.of(page, size, buildSortDirection(sort, propertyName, direction));
    }

    public static <E, R> R convert(E fromValue, Class<R> target) {
        return objectMapper.convertValue(fromValue, target);
    }

    public static <E, R> List<R> convertAll(Collection<E> fromValues, Class<R> target) {
        final var list = new ArrayList<R>();
        fromValues.forEach(value -> list.add(convert(value, target)));
        return list;
    }

    public static <E, R> R convert(E fromValue, TypeReference<R> target) {
        return objectMapper.convertValue(fromValue, target);
    }

    public static <E, R> Page<R> convertToPage(E fromValue, TypeReference<Page<R>> target) {
        return objectMapper.convertValue(fromValue, target);
    }

    public static <E, R> Set<R> convert(List<E> fromValues, TypeReference<Set<R>> target) {
        return objectMapper.convertValue(fromValues, target);
    }

    public static <E, R> List<R> convertToList(List<E> fromValues, TypeReference<List<R>> target) {
        return objectMapper.convertValue(fromValues, target);
    }

    public static <E, R> Set<R> convert(Set<E> fromValues, TypeReference<Set<R>> target) {
        return objectMapper.convertValue(fromValues, target);
    }
}
