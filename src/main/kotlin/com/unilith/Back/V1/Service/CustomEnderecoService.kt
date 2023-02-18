package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Exceptions.RequestObjectNotFoundException
import com.unilith.Back.V1.Mapper.ApiMapper.viaCepMapper
import com.unilith.Back.V1.Mapper.Custom.EnderecoMapper
import com.unilith.Back.V1.Util.ViaCepApi
import com.unilith.Back.V1.Vo.V1.EnderecoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomEnderecoService {

    @Autowired
    lateinit var viaCepApi:ViaCepApi
    @Autowired
    lateinit var enderecoMapper: EnderecoMapper;
    @Autowired
    lateinit var viaCepMapper: viaCepMapper;

    fun buscarViaCep(cep:String):EnderecoVo{

        var viacep = viaCepApi.findByCep(cep);
        if(viacep.erro){
            throw RequestObjectNotFoundException();
        }
        return enderecoMapper.convertVo(viaCepMapper.convertEntity(viacep));

    }


}