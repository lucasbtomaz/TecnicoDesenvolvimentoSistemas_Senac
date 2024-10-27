/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.pridecare.Interface;

import br.com.pridecare.Model.Medico;

/**
 *
 *  oluca
 */
public interface IMedicoDAO {
    void save(Medico medico);
    Medico findById(int id);
}