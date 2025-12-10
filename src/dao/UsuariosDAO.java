/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CraProduto;
import bean.CrsUsuarios;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class UsuariosDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();        
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();        
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();        
        session.delete(object);
        session.getTransaction().commit();        
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CrsUsuarios.class);
        criteria.add(Restrictions.eq("idusuarios", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    
     public CrsUsuarios autenticar(String apelido, String senha) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CrsUsuarios.class);
        criteria.add(Restrictions.eq("craApelido", apelido));
        criteria.add(Restrictions.eq("craSenha", senha));
        CrsUsuarios usuario = (CrsUsuarios) criteria.uniqueResult();
        session.getTransaction().commit();
        return usuario;
    }
     public Object listApelido(String apelido) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CrsUsuarios.class);
        criteria.add(Restrictions.like("craApelido", "%" + apelido + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

   public List listDataNascimento(Date dataNascimento) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CrsUsuarios.class);
        criteria.add(Restrictions.ge("craDataNascimento", dataNascimento));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listApelidoData(String apelido, Date dataNascimento) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CrsUsuarios.class);
        criteria.add(Restrictions.like("craApelido", "%" + apelido + "%"));
        criteria.add(Restrictions.ge("craDataNascimento",  dataNascimento ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }



    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CrsUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.listAll();
    }
}
