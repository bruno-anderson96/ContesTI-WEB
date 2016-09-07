package br.com.contesti.dao;

import javax.transaction.Transaction;

import org.hibernate.Session;

public class GenericDAO<T> {
	
	private Session sessao;
	private Transaction transacao;
	
	public boolean salvar(T t){
//		try {
//			sessao = 
//		} catch (HibernateException e) {
//			System.out.println(e.getMessage());
//		}
		return true;
	}

}
