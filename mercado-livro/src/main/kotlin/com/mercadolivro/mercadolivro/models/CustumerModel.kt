package com.mercadolivro.mercadolivro.models

data class CustumerModel(
    var id : String,
    var nome : String,
    var email: String
)
/*
Sim, você está certo. O uso da palavra-chave dataantes da declaração da classe
CustomerModelindica que essa classe é uma classe de dados.
 As classes de dados em Kotlin são especialmente projetadas para representar estruturas de dados
 imutáveis .que carregam apenas informações (dados) e não têm lógica de negócios complexos.

As classes de dados geram automaticamente alguns métodos padrão que são úteis ao trabalhar com dados,
 como equals(), hashCode(), toString(), permitindo uma comparação fácil, impressão e uso em coleções.*/