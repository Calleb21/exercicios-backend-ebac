package br.com.calleb.controller;

import br.com.calleb.domain.Cliente;
import br.com.calleb.service.IClienteService;
import br.com.calleb.utils.ReplaceUtils;
import scala.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Description of ClienteController
 * Created by calle on 01/02/2024.
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

    private static final long serialVersionUID = 8030245985235567808L;

    private Cliente cliente;

    private Collection<Cliente> clientes;

    @Inject
    private IClienteService clienteService;

    private Boolean isUpdate;

    private String cpfMask;

    private String telMask;

    @PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.cliente = new Cliente();
            this.clientes = clienteService.buscarTodos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os clientes"));
        }
    }

    public void cancel() {
        try {
            this.isUpdate = false;
            this.cliente = new Cliente();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
        }

    }

    public void edit(Cliente cliente) {
        try {
            this.isUpdate = true;
            this.cliente = cliente;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
        }

    }

    public void delete(Cliente cliente) {
        try {
            clienteService.excluir(cliente);
            clientes.remove(cliente);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
        }

    }

    public void add() {
        try {
            removerCaracteresInvalidos();
            limparCampos();
            clienteService.cadastrar(cliente);
            this.clientes = clienteService.buscarTodos();
            this.cliente = new Cliente();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o cliente"));
        }


    }

    private void removerCaracteresInvalidos() {
        Long cpf = Long.valueOf(ReplaceUtils.replace(getCpfMask(), ".", "-"));
        this.cliente.setCpf(cpf);

        Long tel = Long.valueOf(ReplaceUtils.replace(getTelMask(), "(", ")", " ", "-"));
        this.cliente.setTel(tel);
    }

    private void limparCampos() {
        setCpfMask(null);
        setTelMask(null);
    }

    public void update() {
        try {
            removerCaracteresInvalidos();
            clienteService.alterar(this.cliente);
            cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualiado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o cliente"));
        }

    }

    public String voltarTelaInicial() {
        return "/index.xhtml";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getCpfMask() {
        return cpfMask;
    }

    public void setCpfMask(String cpfMask) {
        this.cpfMask = cpfMask;
    }

    public String getTelMask() {
        return telMask;
    }

    public void setTelMask(String telMask) {
        this.telMask = telMask;
    }
}
