package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Repository.BairroRepository
import com.unilith.Back.V1.Repository.CidadeRepository
import com.unilith.Back.V1.Repository.EnderecoRepository
import com.unilith.Back.V1.Repository.UfRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class EnderecoService {

    @Autowired
    lateinit var ufRepository: UfRepository
    @Autowired
    lateinit var cidadeRepository: CidadeRepository
    @Autowired
    lateinit var bairroRepository: BairroRepository
    @Autowired
    lateinit var enderecoRepository: EnderecoRepository












}