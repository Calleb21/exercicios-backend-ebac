/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.dao;

import java.util.HashSet;
import java.util.Set;
import javaapplication1.domain.Cliente;

/**
 *
 * @author calle
 */
public class ClienteSetDAO implements IClienteDAO{
    
    private Set<Cliente> set;
    
    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.set.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteEncontrato = null;
        for (Cliente cliente : this.set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrato = cliente;
                break;
            }
        }
        
        if (clienteEncontrato != null) {
            this.set.remove(clienteEncontrato);
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            for (Cliente clienteCadastrado : this.set) {
                if (clienteCadastrado.equals(cliente)) {
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setTel(cliente.getTel());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente clienteCadastrado : this.set) {
             if (clienteCadastrado.getCpf().equals(cpf)) {
                 return clienteCadastrado;
             }
        }
        return null;
    }
}
