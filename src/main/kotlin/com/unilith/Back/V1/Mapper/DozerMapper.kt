package com.unilith.Back.V1.Mapper

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper
import org.springframework.stereotype.Service

@Service
object DozerMapper {
    private val mapper: Mapper = DozerBeanMapperBuilder.buildDefault();

    fun <O, D> parseObject(origem: O, destination: Class<D>?): D {
        return mapper.map(origem, destination)
    }

    fun <O, D> parseListObject(origem: List<O>, destination: Class<D>?): ArrayList<D> {
        val destinationObjects: ArrayList<D> = ArrayList();
        for (o in origem) {
            destinationObjects.add(mapper.map(o, destination))
        }
        return destinationObjects
    }
}