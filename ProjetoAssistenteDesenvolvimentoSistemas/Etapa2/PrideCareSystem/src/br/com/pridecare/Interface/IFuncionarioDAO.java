/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.pridecare.Interface;

import br.com.pridecare.Model.Funcionario;

/**
 *
 *  oluca
 */
public interface IFuncionarioDAO {
    void save(Funcionario funcionario);
    Funcionario findById(int id);
}
