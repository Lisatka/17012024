import java.sql.*;
import java.util.*;

public class UpdateMySQL {
    public static void main(String[] args) {
        String status = "Nada aconteceu ainda.";
        Connection conn = App.conectar();
        Scanner scnLogin = new Scanner(System.in);
        Scanner scnSenha = new Scanner(System.in);

        try {
            System.out.println("Bem vindo ao Banco de Dados.");
            System.out.println("Digite o login para realizar o cadastrado: ");
            String strLogin = scnLogin.nextLine();
            System.out.println("Digite a senha que será cadastrada: ");
            String strSenha = scnSenha.nextLine();

            
            String strSqlSelect = "SELECT * FROM `mysql_connector`.`tbl_login` WHERE `login` = '" + strLogin + "' AND `senha` = '" + strSenha + "';";
            Statement stmSql = conn.createStatement();
            ResultSet rsSql = stmSql.executeQuery(strSqlSelect);

            if (rsSql.next()) {
               
                status = "Ops! Este login já está cadastrado.";
            } else {
               
                String strSqlInsert = "INSERT INTO `mysql_connector`.`tbl_login` (`login`, `senha`) VALUES ('" + strLogin + "', '" + strSenha + "');";
                stmSql.executeUpdate(strSqlInsert);

               
                status = "Cadastro realizado com sucesso!";
            }

            stmSql.close();
            rsSql.close();
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu o erro " + e);
        }

        System.out.println(status);
    }
}