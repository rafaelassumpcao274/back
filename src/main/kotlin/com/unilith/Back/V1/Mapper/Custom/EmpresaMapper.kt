package com.unilith.Back.V1.Mapper.Custom

import com.unilith.Back.V1.Entity.V1.Empresa
import com.unilith.Back.V1.Mapper.ICustom.CustomMapper
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.EmpresaVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmpresaMapper: CustomMapper<EmpresaVo,Empresa> {

    @Autowired
    lateinit var enderecoMapper: EnderecoMapper

    @Autowired
    lateinit var auditoriaUtil: AuditoriaUtil

    override fun convertVo(entity: Empresa): EmpresaVo {
        val empresaVo:EmpresaVo = EmpresaVo();

        empresaVo.id = entity.id;
        empresaVo.nomeEmpresa = entity.nomeEmpresa;
        empresaVo.cnpj = entity.cnpj;
        empresaVo.email = entity.email;
        empresaVo.contato = entity.contato;
        empresaVo.razaoSocial = entity.razaoSocial;
        empresaVo.telefone = entity.telefone;
        empresaVo.endereco = entity.endereco?.let { enderecoMapper.convertVo(it) };
        auditoriaUtil.convertVo(entity,empresaVo)


        return empresaVo;
    }

    override fun convertEntity(vo: EmpresaVo): Empresa {

        val empresa:Empresa = Empresa();

        empresa.id = vo.id;
        empresa.nomeEmpresa = vo.nomeEmpresa;
        empresa.cnpj = vo.cnpj;
        empresa.email = vo.email;
        empresa.contato = vo.contato;
        empresa.razaoSocial = vo.razaoSocial;
        empresa.telefone = vo.telefone;
        empresa.endereco = vo.endereco?.let { enderecoMapper.convertEntity(it) };


        return empresa;
    }
}