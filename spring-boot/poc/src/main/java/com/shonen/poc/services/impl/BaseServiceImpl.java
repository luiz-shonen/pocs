package com.shonen.poc.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shonen.poc.models.Base;
import com.shonen.poc.resources.requests.BaseRequest;
import com.shonen.poc.resources.responses.BaseResponse;
import com.shonen.poc.resources.responses.Response;
import com.shonen.poc.services.BaseService;
import com.shonen.poc.services.exception.BaseException;
import com.shonen.poc.services.repositories.BaseRepository;
import com.shonen.poc.utils.Utils;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
public class BaseServiceImpl<T extends Base, X extends BaseRequest, Y extends BaseResponse> implements BaseService<T, X, Y> {
    private final Class<T> entity;
    private final Class<X> request;
    private final Class<Y> response;
    private final BaseRepository<T> baseRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public BaseServiceImpl(Class<T> entity, Class<X> request, Class<Y> response, BaseRepository<T> baseRepository) {
        this.entity = entity;
        this.request = request;
        this.response = response;
        this.baseRepository = baseRepository;
    }

    @Override
    public List<T> findAllEntities() {
        return baseRepository.findAll();
    }

    @Override
    public Response findAll() {
        final var res = findAllEntities()
                .stream().map(e -> objectMapper.convertValue(e, response))
                .toList();

        return Utils.response(res);
    }

    @Override
    public Response findAllPageSort(@NonNull Integer page, @NonNull Integer size, String sort, Sort.Direction direction) {
        return Utils.response(
                baseRepository.findAll(Utils.buildPageRequest(page, size, sort, direction))
                        .map(e -> Utils.convert(e, response))
        );
    }

    @Override
    public Response findAllSearchPageSort(Integer page, Integer size, String sort, Sort.Direction direction, @NonNull List<Object> q) {
        throw new BaseException("Não implementado!");
    }

    @Override
    public Response findAllSearchPageSortAtivo(Integer page, Integer size, String sort, Sort.Direction direction, List<Object> q, Boolean ativo) {
        throw new BaseException("Não implementado!");
    }

    @Override
    public T findEntityById(@NonNull Long id) {
        return baseRepository.findById(id).orElse(null);
    }

    @Override
    public Response findById(@Valid @NonNull Long id) {
        return Utils.response(
                baseRepository.findById(id)
                        .map(e -> Utils.convert(e, response))
                        .orElse(null)
        );
    }

    @Transactional
    @Override
    public T saveEntity(@NonNull X baseRequest) {
        return baseRepository.save(Utils.convert(baseRequest, entity));
    }

    @Transactional
    @Override
    public Response save(@Valid @NonNull X baseRequest) {
        return Utils.response(
                Utils.convert(saveEntity(baseRequest), response)
        );
    }

    @Transactional
    @Override
    public Response update(@Valid @NonNull Long id, @Valid @NonNull X baseRequest) {
        return Utils.response(baseRepository.findById(id)
                .map(e -> {
                    e = Utils.convert(baseRequest, entity);
                    e.setId(id);
                    return Utils.convert(baseRepository.save(e), response);
                }).orElseThrow(() -> new BaseException("Item não encontrado!"))
        );
    }

    @Transactional
    @Override
    public void delete(@NonNull Long id) {
        baseRepository.deleteById(id);
    }
}
