/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.dao;

import javaapplication1.domain.Cliente;

/**
 *
 * @author calle
 */
public interface IClienteDAO {
    
    public Boolean cadastrar(Cliente cliente);
    
    public void excluir(Long cpf);
    
    public void atualizar (Cliente cliente);
    
    public Cliente consultar(Long cpf);
}
