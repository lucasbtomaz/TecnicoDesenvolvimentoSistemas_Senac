/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.pridecare.Interface;

import br.com.pridecare.Model.Paciente;

/**
 *
 *  oluca
 */
public interface IPacienteDAO {
    void save(Paciente paciente);
    Paciente findById(int id);    
}
