package aplication;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<Employee>();
        System.out.println("How many employees will be registered? ");
        int N = sc.nextInt();

        for(int i =0;i<N;i++){
            System.out.println("Employee #" + (i+1) + ":");
            System.out.println("Id: ");
            Integer id = sc.nextInt();
            //se id pertence a lista tente outro para eliminar repetições
            while(hasId(list,id)){
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }
            System.out.println("Name: ");
            sc.nextLine();//usa-se para consumir o enter de confirmação do id
            String name = sc.nextLine();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();
            //instanciar objeto com os atributos
            Employee emp = new Employee(id,name,salary);
            // list.add para adicionar
            list.add(emp);
        }
        System.out.println();
        System.out.println("Enter the employee id that will have salary increase: ");
        int idSalaryIncremento =sc.nextInt();
        //trasnf em stream pra filtrar todos elementos x tal que getId ==id e pega o prim caso n traga null
        //Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        Integer pos = position(list,idSalaryIncremento);
        if(pos == null){
            System.out.println("This id does not exist!");
        }else{
            System.out.println("Enter the percentage: ");
            double percent = sc.nextDouble();
            list.get(pos).increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of employees: ");
        for(Employee emp : list){
            System.out.println(emp);
        }
        sc.close();
    }
    //tem id? qual posição? tendo id igual retorne caso n retorne null
    public static Integer position(List<Employee> list, int id){
        //percorro a list pelo id n encontrando retorno null
    for(int i =0;i< list.size();i++){
        if(list.get(i).getId() == id){
           return i;
        }
    } return null;
    }
    public  static boolean hasId(List<Employee> list,int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp !=null;
    }

}
