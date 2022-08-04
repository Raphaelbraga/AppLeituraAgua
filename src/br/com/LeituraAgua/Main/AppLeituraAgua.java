/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.LeituraAgua.Main;

import br.com.LeituraAgua.controler.ConsumidorControler;
import br.com.LeituraAgua.controler.EnderecoControler;
import br.com.LeituraAgua.controler.HidrometroControler;
import br.com.LeituraAgua.controler.UsuarioControler;
import br.com.model.Consumidor;
import br.com.model.Endereco;
import br.com.model.Hidrometro;
import br.com.model.Usuario;
import java.util.Scanner;


public class AppLeituraAgua {
  
    public static void main(String[] args) {
/*
//-----------seta e cadastra usuario comum e admin e executa logim -----------------------------------------
       
        UsuarioControler usuControl = new UsuarioControler();
        
        Usuario usuarioTeste = new Usuario();
        usuarioTeste.setLogin("raphael");
        usuarioTeste.setSenha(123456);
        usuarioTeste.setTipoUsuario("admin");
        
        usuControl.cadastrarNovo(usuarioTeste);
        System.out.println(usuarioTeste);
        
        Usuario usuarioTeste2 = new Usuario();
        usuarioTeste2.setLogin("usuariorr");
        usuarioTeste2.setSenha(102030);
        usuarioTeste2.setTipoUsuario("leiturista");
        
        usuControl.cadastrarNovo(usuarioTeste2);
        System.out.println(usuarioTeste2);

        UsuarioControler loginController = new UsuarioControler();
        
        loginController.logarUsuario("raphael", 123456);
        System.out.println(loginController.getMensagem());

        loginController.logarUsuario("usuario", 102030);
        System.out.println(loginController.getMensagem());

 */
/*    
//************    seta e cadastra endereço 1 e 2 ********************************
        EnderecoControler endereControl = new EnderecoControler();
        
        Endereco endereco1 = new Endereco();
        endereco1.setRua(" do cleumar");
        endereco1.setNumero(10);
        endereco1.setComplemento("casa");
        endereco1.setDistrito("novo sobradinho");
        endereco1.setBairro("sem bairro");
        endereco1.setCidade("toledo");
        
        var novoEnd1 = endereControl.cadastraNovo(endereco1);

        System.out.println(endereco1);
        System.out.println(novoEnd1);
        System.out.println(endereControl.getMensagem());
       
        
        Endereco endereco2 = new Endereco();
        endereco2.setRua(" do cleumar");
        endereco2.setNumero(20);
        endereco2.setComplemento("casa");
        endereco2.setDistrito("novo sobradinho");
        endereco2.setBairro("sem bairro");
        endereco2.setCidade("toledo");
        
        var novoEnd2 = endereControl.cadastraNovo(endereco2);
        
        System.out.println(endereco2);
        System.out.println(novoEnd2);
        System.out.println(endereControl.getMensagem());
        System.out.print("\n");
        
        
//************    seta e cadastra consumidor 1 e 2 ********************************    
        ConsumidorControler consumidorControl = new ConsumidorControler();
        
        Consumidor consumidor1 = new Consumidor();
        consumidor1.setNome("morador 1");
        consumidor1.setContato("1111111111");
        consumidor1.setCpf("11111111111");
        var novoConsum1 = consumidorControl.cadastraNovo(consumidor1);
        
        System.out.println(novoConsum1);
        System.out.println(consumidorControl.getMensagem());
        
        Consumidor consumidor2 = new Consumidor();
        consumidor2.setNome("morador 2");
        consumidor2.setContato("2222222222");
        consumidor2.setCpf("22222222222");
        var novoConsum2 = consumidorControl.cadastraNovo(consumidor2);
        
        System.out.println(novoConsum2);
        System.out.println(consumidorControl.getMensagem());
        System.out.print("\n");
        
//************    seta e cadastra hidrometro 1 e 2 ********************************
        HidrometroControler hidrometroControl = new HidrometroControler();
       
        Hidrometro hidrometro = new Hidrometro();
        hidrometro.setLeituraInstalacao(100);
        hidrometro.setTagHidrometro(001);
        hidrometro.setSituacao(true);
        hidrometro.setIdConsumidor(novoConsum1.getIdConsumidor());
        hidrometro.setIdEndereco(novoEnd1.getIdEndereco());
        
        var novoHidro = hidrometroControl.cadastraNovo(hidrometro);
        System.out.println(""+ novoHidro);        
        System.out.println(consumidorControl.getMensagem());
        
        Hidrometro hidrometro1 = new Hidrometro();
        hidrometro1.setLeituraInstalacao(200);
        hidrometro1.setTagHidrometro(002);
        hidrometro1.setSituacao(true);
        hidrometro1.setIdConsumidor(novoConsum2.getIdConsumidor());
        hidrometro1.setIdEndereco(novoEnd2.getIdEndereco());
        
        var novoHidro1 = hidrometroControl.cadastraNovo(hidrometro1); 
        System.out.println(""+ novoHidro1);
        System.out.println(consumidorControl.getMensagem());
       
        Hidrometro hidrometro3 = new Hidrometro();
        hidrometro3.setLeituraInstalacao(150);
        hidrometro3.setTagHidrometro(003);
        hidrometro3.setSituacao(true);
        hidrometro3.setIdConsumidor(novoConsum2.getIdConsumidor());
        hidrometro3.setIdEndereco(novoEnd1.getIdEndereco());
        
        var novoHidro2 = hidrometroControl.cadastraNovo(hidrometro3); 
        System.out.println(""+ novoHidro2);
        System.out.println(consumidorControl.getMensagem());
       
       
//************    edita usuario por seleção de ID ********************************
       
       UsuarioControler usuControl = new UsuarioControler();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("digite id");
        int idUsu = sc.nextInt();
        
        Usuario usufind = usuControl.pesquisaPorId(idUsu);
  
        System.out.println(usufind);
        
        usufind.setTipoUsuario("leiturista");
        usufind.setLogin("guilherme");
        usufind.setSenha(112233);
        usufind.setIdUsuario(2);
        
        usuControl.atualizarPorId(usufind);
        System.out.println(usufind);
        
       

      HidrometroControler pesquisaHidrometro = new HidrometroControler();
      
      Scanner sc = new Scanner(System.in);
        System.out.println("digite id");
        int idHidro = sc.nextInt();
        
        Hidrometro hidrofind = pesquisaHidrometro.pesquisaPorId(idHsu);
  
        System.out.println(hidrofind);
         
        Scanner sc = new Scanner(System.in);
        System.out.println("digite id do hidrometro para pesquisa");
        int idHidro = sc.nextInt();
        
        System.out.println("digite cpf do novo usuario para o hidrometro");
        String idconsu = sc.next();
        
        
        Hidrometro hidroPesquisa = hidrometroControl.pesquisaPorId(idHidro);
        Consumidor usuConsu = consumidorControl.consultarPorCof(idconsu);
        
        System.out.println("" + usuConsu);
        System.out.println("" + hidroPesquisa);
        
        hidroPesquisa.setLeituraInstalacao(138);
        hidroPesquisa.setSituacao(true);
        hidroPesquisa.setIdConsumidor(usuConsu.getIdConsumidor());
        hidroPesquisa.setIdEndereco(novoEnd1.getIdEndereco());

        System.out.println("" + hidroPesquisa);
        var hidroAtualiza = hidrometroControl.atualizar(hidroPesquisa);
        System.out.println("" + hidroAtualiza);
        System.out.println("" + hidroPesquisa);
        
        
        
//************    edita hidrometro pelo id e cpf de usuario ********************************
        
        System.out.println("digite o id do hidrometro para delet");
        int idDeleteHidro = sc.nextInt();
        
        Hidrometro hidrodelet = hidrometroControl.pesquisaPorId(idDeleteHidro);
        System.out.println(""+hidrodelet);
        var deletado = hidrometroControl.deletar(hidrodelet);
        System.out.println(""+deletado);
        System.out.println(""+hidrodelet);
        
      */
    }
}