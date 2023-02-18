package com.unilith.Back.V1.Mapper.ApiMapper

import com.unilith.Back.V1.Entity.V1.Bairro
import com.unilith.Back.V1.Entity.V1.Cidade
import com.unilith.Back.V1.Entity.V1.Endereco
import com.unilith.Back.V1.Entity.V1.Uf
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Vo.V1.ViaCep.ViaCep
import org.springframework.stereotype.Service

@Service
class viaCepMapper:CustomMapper<ViaCep,Endereco>{
    override fun convertVo(entity: Endereco): ViaCep {
        var viaCep:ViaCep = ViaCep();
        viaCep.logradouro = entity.descricao;
        viaCep.cep = entity.cep.toString();
        viaCep.bairro = entity.bairro?.descricao;
        viaCep.localidade = entity.bairro?.cidade?.descricao;
        viaCep.uf = entity.bairro?.cidade?.uf?.descricao;

        return viaCep;
    }

    override fun convertEntity(vo: ViaCep): Endereco {

        var endereco:Endereco = Endereco();
        var bairro:Bairro = montarObjetoBairro(vo.bairro);
        var cidade:Cidade = montarObjetoCidade(vo.localidade);
        var uf:Uf = montarObjetoUf(vo.uf);




        endereco.descricao = vo.logradouro;
        endereco.cep = vo.cep.replace("-","").toInt();
        endereco.bairro = bairro;
        endereco.bairro.cidade = cidade;
        endereco.bairro.cidade.uf = uf;
        return endereco;
    }

    fun montarObjetoBairro(descricao:String):Bairro{
        var bairro:Bairro = Bairro();
        bairro.descricao = descricao;
        return bairro;
    }

    fun montarObjetoCidade(descricao:String):Cidade{
        var bairro:Cidade = Cidade();
        bairro.descricao = descricao;
        return bairro;
    }

    fun montarObjetoUf(descricao:String):Uf{
        var bairro:Uf = Uf();
        bairro.descricao = descricao;
        return bairro;
    }

}