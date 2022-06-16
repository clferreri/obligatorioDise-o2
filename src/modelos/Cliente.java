/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author bolso
 */
public class Cliente {

    private int id;
    private String nombre;
    private String email;
    private TipoCliente tipoCliente;


    public Cliente(int id, String nombre, String email, TipoCliente tipoCliente){
        this.id             = id;
        this.nombre         = nombre;
        this.email          = email;
        this.tipoCliente    = tipoCliente;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    
    public String getNombreBeneficio()
    {
        return this.tipoCliente.beneficio();
    }
    
    public float getTotalBeneficio(Servicio s)
    {
        return this.tipoCliente.getTotalBeneficio(s);
    }

}
