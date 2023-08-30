package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.controller.ControlerRequest.PostCustomerRequest
import com.mercadolivro.mercadolivro.controller.ControlerRequest.PutCustomerRequest
import com.mercadolivro.mercadolivro.models.CustumerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController  /*E controle*/
@RequestMapping("customer")   /*Rota*/
class CustomerController {

    /*Comandos atalho   Alt + Enter  =>  Altera o tipo do metodo automatico*/
    val customers = mutableListOf<CustumerModel>()
    @GetMapping
    fun getCustumer(): MutableList<CustumerModel> {
        return customers
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) /*Para personalizar status personalizado*/
    fun creatCustumer(@RequestBody custumer: PostCustomerRequest) {
        var id = if (customers.isEmpty()){
            1     /*Para quando a lista começar Vazia*/
        }else{
            customers.last().id.toInt() +1
        }.toString()

        customers.add(CustumerModel(id,custumer.nome,custumer.email))
    }
    @GetMapping("/{id}")
    fun getCustormer(@PathVariable id : String): CustumerModel {
        return customers.filter { it.id == id }.first()
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) /*Status Padrao*/
    fun updateCustormer(@PathVariable id : String,@RequestBody custumer: PutCustomerRequest){
        return customers.filter { it.id == id }.first().let {
            it.nome = custumer.nome
            it.email = custumer.email
        }

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) /*Status Padrao*/
    fun deleteCustormer(@PathVariable id : String){
        customers.removeIf {it.id == id }

    }
    // 







}