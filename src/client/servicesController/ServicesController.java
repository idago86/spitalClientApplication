/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.servicesController;

import dto.AdminDTO;
import dto.MedicDTO;
import dto.PacientDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import remote.InterfaceRemote;

/**
 *
 * @author Israel Dago
 */
public class ServicesController {
    private Registry registru;
    private InterfaceRemote remote;
    
    private ServicesController() {
        try {
            registru= LocateRegistry.getRegistry("localhost", 4545); 
            remote = (InterfaceRemote) registru.lookup("spitalServer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
    
        private static final ServicesController SINGLETON = new ServicesController();
    }
    
    public static ServicesController getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public boolean register(String user, String parola) throws Exception{
        AdminDTO admin = new AdminDTO(user, parola);
        return remote.register(admin);
    }
    
    public AdminDTO login (String user, String parola) throws Exception{
        AdminDTO admin = new AdminDTO(user, parola);
        return remote.login(admin);
    }
    
    public void addMedic(String nume, String matricula) throws IOException{
        MedicDTO medic = new MedicDTO(nume, matricula);
        remote.addMedic(medic);
    }
    
    public void addPacient(String nume, String cnp) throws IOException{
        PacientDTO pacient = new PacientDTO(nume, cnp);
        remote.addPacient(pacient);
    }
    
    
    
    
    
}
