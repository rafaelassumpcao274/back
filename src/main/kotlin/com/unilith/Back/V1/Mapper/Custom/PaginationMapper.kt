package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Vo.V1.Paginator
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginationMapper <E> {

    fun  convertPageToPagination(page:Page<E>):Paginator<E>{
        var pagination: Paginator<E> = Paginator();

        pagination.lista = page.content;
        pagination.currentPage = page.number;
        pagination.totalPages = page.totalPages;
        pagination.totalItems = page.numberOfElements;

        return pagination;
    }


    fun <E,O> convertVo(mapper:CustomMapper<O,E> ,entity:Paginator<E>):Paginator<O>{
        var paginatorVo = Paginator<O>()

        paginatorVo.totalItems = entity.totalItems
        paginatorVo.currentPage = entity.currentPage
        paginatorVo.totalPages = entity.totalPages
        paginatorVo.lista = entity.lista?.let { mapper.convertListVo(it) };


        return paginatorVo
    }



}