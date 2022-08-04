/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.UsuarioDAO;
import br.com.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioControler {
   PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    public Usuario cadastrarNovo(Usuario obj) {
        UsuarioDAO solicita = new UsuarioDAO();
        Usuario usuarioexist = solicita.listarPorUsuario(obj.getLogin());

        if (usuarioexist != null) {
            setMensagem("Erro - Usuário ja existe!");
        } else {
            Usuario usuario = solicita.cadastrar(obj);
            setMensagem("sucess - Usuário cadastrado com sucesso");
            return usuario;
        }
        return null;
    }
    
    public Usuario pesquisaPorId(int id) {
        UsuarioDAO consulta = new UsuarioDAO();
        Usuario usuarioId = consulta.listarPorId(id);

        if (usuarioId == null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
            return usuarioId;
        }
            return null;
    }
    
    public Usuario logarUsuario(String login, int senha) {
        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuario = dao.logarUsuario(login, senha);

        if (usuario != null) {

            if (!usuario.getTipoUsuario().equals("admin")) {
                setMensagem("Erro - Usuário: " + usuario.getLogin() + " não possui permissão!");
            } else {
                setMensagem("Usuário: " + usuario.getLogin() + " autenticado com sucesso!");
            }

        } else {
            setMensagem("Erro - Usuário não encontrado!");
        }

        return usuario;
    }

    public List<Usuario> consultarLista() {
        UsuarioDAO consulta = new UsuarioDAO();
        List<Usuario> usuarioLista = consulta.listar();

        if (usuarioLista == null) {
            setMensagem("Erro - lista de usuario não existe");
        } else {
            return usuarioLista;
        }
        return null;
    }
    
    public List<Usuario> consultarListaPorTermo(String termo) {
        UsuarioDAO consulta = new UsuarioDAO();
        List<Usuario> usuarioLista = consulta.listarPorTermo(termo);

        if (usuarioLista == null) {
            setMensagem("Erro - lista de usuario não existe");
        } else {
            return usuarioLista;
        }
        return null;
    }

    public Usuario pesquisarPorNome(String login) {
        UsuarioDAO consulta = new UsuarioDAO();
        Usuario usuarioNome = consulta.listarPorUsuario(login);

        if (usuarioNome == null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
            return usuarioNome;
        }
        return null;
    }
    
    

    public Usuario atualizar(Usuario obj) {
        UsuarioDAO atualiza = new UsuarioDAO();
        Usuario nomeUsuario = atualiza.listarPorId(obj.getIdUsuario());

        if (nomeUsuario == null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
            atualiza.atualizar(obj);
            return nomeUsuario;
        }
        return null;
    }
    
    public Usuario atualizarPorId (Usuario obj) {
        UsuarioDAO atualiza = new UsuarioDAO();
        Usuario usuario = atualiza.listarPorId(obj.getIdUsuario());
        
        if (usuario != null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
           atualiza.atualizar(usuario);
          return usuario;
             
        }
        return null;
    }

    public Boolean deletar(Usuario obj) {
        UsuarioDAO deleta = new UsuarioDAO();
        Usuario usuario = deleta.listarPorUsuario(obj.getLogin());

        if (usuario == null) {
            setMensagem("Erro - Usuário não existe ou ja excluido");
        } else {
            
            Boolean usuDeletado = deleta.deletar(obj);
            if(!usuDeletado){
                setMensagem("falha ao deletar usuario, contate suporte");
            }
            
            return usuDeletado;
        }
        return false;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
   
     
}
