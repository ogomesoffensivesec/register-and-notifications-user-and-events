import controller.ArchivesCRUD;
import model.Evento;
import model.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Main {

    public static void myMenu(String[] escolhas) {
        for (String escolha : escolhas) {
            System.out.println(escolha);
        }
        System.out.println("Faça sua escolha: ");
    }

    public static void main(String[] args) throws IOException {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime nowtime = LocalDateTime.now();
        String[] escolhas = {
                formatador.format(nowtime),
                "1 - CADASTRO DE USUÁRIOS",
                "2 - ADICIONAR EVENTOS",
                "3 - VISUALIZAR EVENTOS DISPONÍVEIS",
                "4 - VISUALIZAR EVENTOS MARCADOS",
                "5 - HISTÓRICO DE EVENTOS",
                "6 - PARTICIPAR DE EVENTO",
                "0 - SAIR"};
        String escolha;
        Usuario user = new Usuario();
        Evento event = new Evento();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            myMenu(escolhas);
            escolha = input.readLine();
            int intescolha = Integer.valueOf(escolha);


            //Cadastro de Usuários
            if (intescolha == 1) {
                String nome, usuario, document, datenasc, email, city, contact, evento;
                System.out.println("Nome completo: ");
                nome = input.readLine();
                System.out.println("Nome de usuário: ");
                usuario = input.readLine();
                System.out.println("Data de nascimento: ");
                datenasc = input.readLine();
                System.out.println("Cidade - Estado: ");
                city = input.readLine();
                System.out.println("Telefone para contato: ");
                contact = input.readLine();
                System.out.println("Email: ");
                email = input.readLine();
                System.out.println("RG ou CPF: ");
                document = input.readLine();


                try {
                    user.setNome(nome);
                    user.setUser(usuario);
                    user.setCity(city);
                    user.setDocument(document);
                    user.setDatenasc(datenasc);
                    user.setEmail(email);
                    user.setContact(contact);
                    System.out.println("Usuário cadastrado com sucesso!");
                    String path = "\\events\\users.data";
                    String infoUsers = "Nome completo: " + user.getNome() + "\n" + "Usuário: " + user.getUser() + "\n" + "Data de Nascimento: " + user.getDatenasc() + "\n" + "Reside em: " + user.getCity() + "\n" + "Contato: " + user.getContact() + "\n" + "E-mail: " + user.getEmail() + "\n" + "Documento (RG OU CPF): " + user.getDocument();
                    ArchivesCRUD.writer(path, infoUsers);
                } catch (Exception erro) {
                    System.out.println("ERRO AO INSERIR NOVO USUÁRIO" + erro);
                }
            }

            //Adicionar evento
            else if (intescolha == 2) {
                String nome, addr, category, description, hour;
                System.out.println("Nome do evento: "); //Inserção do nome do evento
                nome = input.readLine();

                System.out.println("Endereço do Evento: "); //Inserção do Endereço do Evento
                addr = input.readLine();

                System.out.println("Categoria: ");
                category = input.readLine();

                System.out.println("Descrição: ");
                description = input.readLine();

                System.out.println("Dia e Horário (dd/mm/aaa hh:mm) ");
                hour = input.readLine();
                try {
                    event.setName(nome);
                    event.setAddr(addr);
                    event.setDescription(description);
                    event.setCategory(category);
                    event.setHour(hour);
                    String path = "\\events\\events.data"
                    String infoEvent = "Horário do Evento:" +  event.getHour() + "\n" + "Nome: " + event.getName() + "\n" + "Endereço: " +  event.getAddr() + "\n" + "Descrição: " + event.getDescription() + "\n" + "Categoria: " +event.getCategory() + "\n";
                    ArchivesCRUD.writer(path, infoEvent);
                    System.out.println("Evento adicionado com sucesso");
                } catch (Exception e) {
                    System.out.println("ERRO AO INSERIR NOVO EVENTO" + e);
                }
            }

            //Visualizar eventos disponíveis
            else if (intescolha == 3) {
                String path = "\\events\\events.data"
                BufferedReader buffRead = new BufferedReader((new FileReader(path)));
                String linha = buffRead.readLine();
                Pattern pattern_data = Pattern.compile("(\\d{2}/\\d{2}/\\d{4})");
                Pattern pattern_hora = Pattern.compile("\\h{2}/\\:/\\h{2}");


            }

            //Visualizar eventos marcados
            else if (intescolha == 4) {
                System.out.println(user.getListE().toString());
            }

            //Participar de evento
            else if (intescolha == 6) {
                String path = "\\events\\events.data"
               
                BufferedReader buffRead = new BufferedReader((new FileReader(path)));
                String line = "";
                while (true) {
                    if (line != null) {
                        System.out.println(line);
                    } else break;
                    line = buffRead.readLine();
                }
                buffRead.close();

                System.out.println("Qual evento deseja participar?");
                String participar = input.readLine();
                try {
                    user.setEvento(participar);
                } catch (Exception erro) {
                    System.out.println("Erro ao participar do evento: " + erro);
                }
            } else if (intescolha == 000) {
                String path = "\\events\\users.data";
                BufferedReader buffRead = new BufferedReader(new FileReader(path));
                String linha = "";
                while (true){
                    if (linha != null){
                        System.out.println(linha);
                    } else break;
                    linha = buffRead.readLine();
                }
            }
        }
    }
}

