package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;


public class EmployeeDemo {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        boolean out = false;
        int option;
        while(!out){
            System.out.println( "MENU DE EMPLEADOS" +
                    "\n1 - Crear" +
                    "\n2 - Mostrar y Buscar" +
                    "\n3 - Actualizar" +
                    "\n4 - Eliminar" +
                    "\n5 - Salir");
            try{
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        createEmployee();
                        break;
                    case 2:
                        readEmployee();
                        break;
                    case 3:
                        updateEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        out = true;
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            }catch(Exception e){
                System.out.println("Debes insertar un número");
                scanner.next();
            }finally {
                getSession().close();
            }
        }
    }

    private static SessionFactory getSession(){
        return new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
    }

    private static void createEmployee(){

        System.out.print("Ingrese el nombre: ");
        String firstName = scanner.next();
        System.out.print("Ingrese el apellido: ");
        String lastName = scanner.next();
        System.out.print("Ingrese la compania: ");
        String company = scanner.next();
        System.out.println("Creating new Employee..");
        Employee employee = new Employee(firstName,lastName,company);
        getSession();
        Session session = getSession().getCurrentSession();
        session.beginTransaction();
        System.out.println("Saving the Employee...");
        session.save(employee);
        session.getTransaction().commit();
        System.out.println("Saved employee. Generated id: "+ employee.getId());
    }

    private static void readEmployee(){
        boolean out = false;
        int option;
        while(!out){
            System.out.println("1 - Mostrar todos lo empleados" +
                             "\n2 - Buscar un empleado" +
                             "\n3 - Salir");

            try{
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        showAll();
                        break;
                    case 2:
                        searchEmployee();
                        break;
                    case 3:
                        out = true;
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            }catch (Exception e){
                System.out.println("Debes insertar un número");
            }

        }
    }

    private static void showAll() {
        Session session = getSession().getCurrentSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("from Employee").getResultList();
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    private static void searchEmployee() {

        System.out.println("Ingrese el nombre del empleado");
        String firstName = scanner.next();
        System.out.println("Ingrese el id del empleado - si no lo conoce ingrese N");
        String id = scanner.next();
        String query = String.format("from Employee e where e.firstName = '%s' or e.id = '%s'",firstName,id);
        System.out.println(query);
        Session session = getSession().getCurrentSession();
        session.beginTransaction();

        List<Employee> employees = session.createQuery(query).getResultList();
        if(employees.isEmpty()){
            System.out.println("No encontro ninguna coincidencia");
        }else{
            System.out.println("Coincidencias encontradas: ");
            for(Employee employee : employees){
                System.out.println(employee);
            }
        }


        session.getTransaction().commit();
    }



    private static void updateEmployee(){
        System.out.println("Ingrese el id del empleado a modificar");
        int id = scanner.nextInt();
        Session session = getSession().getCurrentSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class,id);
        boolean out = false;
        if(employee == null){
            System.out.println("Empleado no encontrado");
            out = true;
        }else{
            System.out.println(employee);
        }


        int option;

        while(!out){
            System.out.println("Que valor desea modificar?");
            System.out.println("1 - first name" +
                    "\n2 - last name" +
                    "\n3 - company");

            try{
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        System.out.println("Ingrese el nuevo nombre");
                        employee.setFirstName(scanner.next());
                        out = true;
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo apellido");
                        employee.setLastName(scanner.next());
                        out = true;
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva compania");
                        employee.setCompany(scanner.next());
                        out = true;
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            }catch (Exception e){
                System.out.println("Debes insertar un número");
            }

            System.out.println("Updating employee..");
            System.out.println(employee);
            session.getTransaction().commit();
        }

    }

    private static void deleteEmployee(){
        System.out.println("Ingrese el id del empleado a eliminar");
        int id = scanner.nextInt();
        Session session = getSession().getCurrentSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class,id);
        if(employee == null){
            System.out.println("Empleado no encontrado");
        }else{
            System.out.println("Deleting employee: "+employee.getFirstName()+" "+employee.getLastName());
            session.delete(employee);
            session.getTransaction().commit();
            System.out.println("Employee has been deleted");
        }

    }
}
