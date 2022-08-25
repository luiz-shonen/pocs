package com.shonen.poc.controllers;

import com.shonen.poc.models.Base;
import com.shonen.poc.resources.requests.BaseRequest;
import com.shonen.poc.resources.responses.BaseResponse;
import com.shonen.poc.resources.responses.Response;
import com.shonen.poc.services.BaseService;
import lombok.NonNull;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@ResponseBody
public class BaseRestController<T extends Base, X extends BaseRequest, Y extends BaseResponse> {

    private final BaseService<T, X, Y> baseService;

    public BaseRestController(BaseService<T, X, Y> baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Response findAllPageSort(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size, @RequestParam(required = false) String sort, @RequestParam(required = false) Sort.Direction direction) {
        if (page == null || size == null) {
            return baseService.findAll();
        }
        return baseService.findAllPageSort(page, size, sort, direction);
    }

    @GetMapping(value = "/search")
    @ResponseStatus(code = HttpStatus.OK)
    public Response findAllSearchPageSort(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size, @RequestParam(required = false) String sort, @RequestParam(required = false) Sort.Direction direction, @RequestParam @NonNull @NotBlank List<Object> q) {
        return baseService.findAllSearchPageSort(page, size, sort, direction, q);
    }

    @GetMapping("/search/ativo")
    @ResponseStatus(code = HttpStatus.OK)
    public Response findAllSearchPageSortAtivo(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size, @RequestParam(required = false) String sort, @RequestParam(required = false) Sort.Direction direction, @RequestParam(required = false) List<Object> q, @RequestParam @NonNull Boolean ativo) {
        return baseService.findAllSearchPageSortAtivo(page, size, sort, direction, q, ativo);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Response findById(@PathVariable Long id) {
        return baseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Response save(@Valid @NonNull @RequestBody X baseRequest) {
        return baseService.save(baseRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Response update(@PathVariable Long id, @Valid @NonNull @RequestBody X baseRequest) {
        return baseService.update(id, baseRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        baseService.delete(id);
    }
}
