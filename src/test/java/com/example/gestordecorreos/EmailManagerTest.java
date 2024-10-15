package com.example.gestordecorreos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;



public class EmailManagerTest {

    @Test
    public void Mandar_Un_Email_Test() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Hola","A casa joaco",c1 , destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(email1);

        assertEquals("Hola", email1.getAsunto());

        assertEquals(1, c2.bandeja.recibidos.size());
        assertEquals(1, c1.bandeja.enviados.size());
        
    }

    @Test
    public void Mandar_Un_Email_Dos_Contactos_Test() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);
        destinatarios.add(c3);

        Email email1 = new Email("Hola","vamos a casa Joaco",c1, destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(email1);

        assertEquals(1, c3.bandeja.getRecibidos().size());
        assertEquals(1, c2.bandeja.getRecibidos().size());
        assertEquals(1, c1.bandeja.getEnviados().size());
    }

    @Test
    public void Mandar_300_Emails_A_Rodri_Test() {

        Contacto c1 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c2 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        EmailManager em = new EmailManager();
        for (int i = 0; i < 300; i++) {

            Email email1 = new Email("Hola","Rodrix",c1, destinatarios);
            em.enviar(email1);
        }

        assertEquals(300, c1.bandeja.getEnviados().size());
        assertEquals(300, c2.bandeja.getRecibidos().size());
    }
    
    @Test
    public void filtrar_email_por_remitente() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        List<Contacto> destinatarios1 = new ArrayList<>();
        destinatarios1.add(c2);
        
        EmailManager em = new EmailManager();
        Filtro filtro= new Filtro();
        for (int i = 0; i < 3; i++) {

            Email email1 = new Email("Hola","Rodrix",c1, destinatarios1);
            em.enviar(email1);
        }

        List<Contacto> destinatarios2 = new ArrayList<>();
        destinatarios2.add(c3);

        for (int i = 0; i < 3; i++) {

            Email email2 = new Email("Hola","Rodri capo",c1,destinatarios2);
            em.enviar(email2);
        }

        assertEquals(3, filtro.filtrarPorRemitente(c1 , c3.bandeja.getRecibidos()).size());
        
    }

    @Test
    public void filtrar_email_por_destinatario(){

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        EmailManager em = new EmailManager();
        Filtro  filtro= new Filtro(); 
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);
        destinatarios.add(c3);
        
        for (int i = 0; i < 3; i++) {
        
            Email email1 = new Email("Hola","Rodrix",c1,destinatarios);
            em.enviar(email1);
        }

        //em.filtrarPorDestinatario(c1, bandejaFiltrada);
        assertEquals(3, filtro.filtrarPorDestinatario(c2 , c2.bandeja.getRecibidos()).size());

    }
    
    @Test
    public void filtrar_email_asunto() {
        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        EmailManager em = new EmailManager();
        Filtro  filtro= new Filtro();   
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c3);


        for (int i = 0; i < 3; i++) {

            Email email1 = new Email("Hola","Rodrix",c1, destinatarios);
            em.enviar(email1);
        }
        
        for (int i = 0; i < 3; i++) {

            Email email2 = new Email("Adios","Rodri capo",c2,destinatarios);
            em.enviar(email2);
        }


        List<Email> emailsFiltrados = filtro.filtrarPorAsunto("Hola", c3.bandeja.getRecibidos());
        assertEquals(3,emailsFiltrados.size());

        List<Email> emailsFiltradosAdios = filtro.filtrarPorAsunto("Adios", c3.bandeja.getRecibidos());
        assertEquals(3,emailsFiltradosAdios.size());
        
    }
    
    @Test
    public void filtrar_email_parte_Contenido() {
        
        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c3);

        EmailManager em = new EmailManager();


            Email email1 = new Email("Hola","Rodrix",c1, destinatarios);
            em.enviar(email1);

            Email email2 = new Email("Hola","Rodri capo",c2, destinatarios);
            em.enviar(email2);
        Filtro  filtro= new Filtro();


        List<Email> emailsFiltrados = filtro.filtrarPorPalabrasClaves("Rodri", c3.bandeja.getRecibidos());
        assertEquals(2,emailsFiltrados.size());
        
    }

    @Test
    public void filtrar_usuario_puede_buscar_correos_bandeja_entrada() {
        
        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c3);

        EmailManager em = new EmailManager();
        

            Email email1 = new Email("Hola","Rodrix",c1, destinatarios);
            em.enviar(email1);

            Email email2 = new Email("Adios","Rodri capo",c2, destinatarios);
            em.enviar(email2);

            Email email3 = new Email("Nos vemos","Rodri buscar",c2, destinatarios);
            em.enviar(email3);
            
            //Entro a mi bandeja y veo mis correos
            assertEquals(3, c3.bandeja.getRecibidos().size());
            Filtro filtro= new Filtro();

            //Busco por palabra clave
            List<Email> emailsFiltrados = filtro.filtrarPorPalabrasClaves("Rodri", c3.bandeja.getRecibidos());
            assertEquals(3,emailsFiltrados.size());

            //Busco por asunto
            List<Email> emailsFiltrados1 = filtro.filtrarPorAsunto("Hola", c3.bandeja.getRecibidos());
            assertEquals(1,emailsFiltrados1.size());

            //Busco por quien me envio

            assertEquals(2, filtro.filtrarPorRemitente(c2 , c3.bandeja.getRecibidos()).size());

    }



    /*----------------Filtros con clase filtro y "predicados"----------------- */
    @Test
    public void filtrar_email_filtroClases() {
        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Reunion","Ivan",c1, destinatarios);
            
        EmailManager em = new EmailManager();
        em.enviar(email1);
        

        Predicate<Email> predicadoPorAsunto = email->email.getAsunto().equals("Reunion");


        Filtro filtro1 = new Filtro("Filtro por Asunto",predicadoPorAsunto ); //Se crea el filtro por destinatario
        List<Email> emailsFiltrados = filtro1.buscarConFiltro(filtro1, c2.bandeja.getRecibidos());

        // Verificar que se filtró un mensaje
        assertEquals(1, emailsFiltrados.size());
        assertEquals("Reunion", emailsFiltrados.get(0).getAsunto());  // Verificar que el asunto es "Reunion"
        
    }

    @Test
    public void filtrar_email_filtroClases_Palabra_Clave() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Hola","Se lo convoca el día de la fecha para poder ver el nuevo GTVI",c1, destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(email1);

        Predicate<Email> predicadoPorPalabraClave = email -> email.getContenido().contains("convoca");

        Filtro filtro1 = new Filtro("Filtro por Palabra Clave", predicadoPorPalabraClave);

        List<Email> emailsFiltrados = filtro1.buscarConFiltro(filtro1, c2.bandeja.getRecibidos());

        assertEquals(1, emailsFiltrados.size());

        assertTrue(emailsFiltrados.get(0).getContenido().contains("convoca"));
    }

    @Test
    public void filtrar_email_filtroClases_Remitente() {
        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Hola","Ivan", c1, destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(email1);

        Predicate<Email> predicadoPorRemitente = email -> email.getRemitente().equals(c1);

        Filtro filtro1 = new Filtro("Filtro por Remitente", predicadoPorRemitente);

        //Se almacena en una lista, los emails filtrados
        List<Email> emailsFiltrados = filtro1.buscarConFiltro(filtro1, c2.bandeja.getRecibidos());

        assertEquals(1, emailsFiltrados.size());

        assertEquals(c1, emailsFiltrados.get(0).getRemitente());
    }

    @Test
    public void filtrar_email_filtroCombinado_AsuntoYPalabraClave() {
        Contacto c2 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c1 = new Contacto("Silvia", "Hoferek", "silvia@upc.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Reunion en la UCP","Se lo convoca el dia de la fecha para discutir el nuevo proyecto",c1, destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(email1);

        Predicate<Email> predicadoPorAsunto = email -> email.getAsunto().contains("Reunion");
        Predicate<Email> predicadoPorPalabraClave = email -> email.getContenido().contains("proyecto");

        Predicate<Email> predicadoCombinado = predicadoPorAsunto.and(predicadoPorPalabraClave);

        Filtro filtroCombinado = new Filtro("Filtro Combinado Asunto y Palabra Clave", predicadoCombinado);

        List<Email> emailsFiltrados = filtroCombinado.buscarConFiltro(filtroCombinado, c2.bandeja.getRecibidos());

        assertEquals(1, emailsFiltrados.size());

        assertTrue(emailsFiltrados.get(0).getAsunto().contains("Reunion"));

        assertTrue(emailsFiltrados.get(0).getContenido().contains("proyecto"));
    }

    @Test
    public void filtrar_email_filtroCombinado_Asunto_PalabraClaveYRemitente() {
        Contacto c2 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c1 = new Contacto("Silvia", "Hoferek", "silvia@upc.com");
        
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Reunion en la UCP","Se lo convoca el dia de la fecha para discutir el nuevo proyecto.", c1, destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(email1);

        for (int i = 0; i < 5; i++){
            Email email2 = new Email("Consulta clase", "Que se dio en la clase de fecha" + i,  c1, destinatarios);
            em.enviar(email2);
        }

        Predicate<Email> predicadoPorAsunto = email -> email.getAsunto().contains("Reunion");
        Predicate<Email> predicadoPorPalabraClave = email -> email.getContenido().contains("proyecto");
        Predicate<Email> predicadoRemitente = email -> email.getRemitente().equals(c1);


        Predicate<Email> predicadoCombinado = predicadoPorAsunto.and(predicadoPorPalabraClave).and(predicadoRemitente);

        Filtro filtroCombinado = new Filtro("Filtro Combinado Asunto,Palabra Clave y Remitente", predicadoCombinado);

        List<Email> emailsFiltrados = filtroCombinado.buscarConFiltro(filtroCombinado, c2.bandeja.getRecibidos());

        assertEquals(1, emailsFiltrados.size());

        assertTrue(emailsFiltrados.get(0).getAsunto().contains("Reunion"));
        assertEquals("Filtro Combinado Asunto,Palabra Clave y Remitente", filtroCombinado.getNombre());

        assertTrue(emailsFiltrados.get(0).getContenido().contains("proyecto"));
        assertTrue(emailsFiltrados.get(0).getRemitente().equals(c1));
    }

    @Test
    public void filtrar_email_filtrarCombinado_asunto_destinatario_palabraClave() {
        
        Contacto c1 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c2 = new Contacto("Silvia", "Hoferek", "silvia@upc.com");
        Contacto c3 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        EmailManager em = new EmailManager();
        for (int i = 0; i < 5; i++){
            Email email1 = new Email("Consulta clase", "Que se dio en la clase de fecha " + i,  c1, destinatarios);
            em.enviar(email1);
        }

        for (int i = 0; i < 5; i++){
            Email email2 = new Email("Ausente", "Falte a la clase de fecha " + i,  c3, destinatarios);
            em.enviar(email2);
        }


        Predicate<Email> predicadoPorAsunto = email -> email.getAsunto().contains("Consulta clase");
        Predicate<Email> predicadoPorPalabraClave = email -> email.getContenido().contains("Que se dio en la clase de fecha 2");
        Predicate<Email> predicadoRemitente = email -> email.getRemitente().equals(c1);

        //Predicate<Email> predicadoDestinatario = email -> email.getDestinatarios()[0].equals(c2);


        Predicate<Email> predicadoCombinado = predicadoPorAsunto.and(predicadoPorPalabraClave).and(predicadoRemitente);

        Filtro filtroCombinado = new Filtro("Filtro Combinado Asunto, Palabra Clave y Remitente", predicadoCombinado);

        List<Email> emailsFiltrados = filtroCombinado.buscarConFiltro(filtroCombinado, c2.bandeja.getRecibidos());

        assertEquals(1, emailsFiltrados.size());

        assertTrue(emailsFiltrados.get(0).getAsunto().contains("Consulta clase"));
        assertEquals("Filtro Combinado Asunto, Palabra Clave y Remitente", filtroCombinado.getNombre());

        assertTrue(emailsFiltrados.get(0).getContenido().contains("Que se dio en la clase de fecha 2"));
        assertTrue(emailsFiltrados.get(0).getRemitente().equals(c1));


    }


    @Test
    public void borrar_correos1(){

        Contacto c1 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c2 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c1);

        EmailManager em = new EmailManager();
        for (int i = 0; i < 5; i++){
            Email email1 = new Email("Sale cs?", "Vamos a jugar",  c2, destinatarios);
            em.enviar(email1);
        }

        for (int i = 0; i < 5; i++){
            Email email2 = new Email("Sale estudiar?", "Vamos a estudiar",  c3, destinatarios);
            em.enviar(email2);
        }
        Filtro filtro = new Filtro();

        //borrar todos los emails de Rodri en la bandeja de ivan

        List<Email> emailsFiltradosRodri = filtro.filtrarPorRemitente(c3, c1.bandeja.getRecibidos());

        assertEquals(5, emailsFiltradosRodri.size());

        List<Email> emailsFiltradosAugusto = filtro.filtrarPorRemitente(c2, c1.bandeja.getRecibidos());

        assertEquals(5, emailsFiltradosAugusto.size());

        assertEquals(c1.bandeja.getRecibidos().size(), 10);
        
        em.borrar(emailsFiltradosRodri);

        assertEquals(c1.bandeja.getRecibidos().size(), 5);

    }

    @Test
    public void mandar_email_Crear_grupo(){

        Contacto c1 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c2 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");
        Contacto c4 = new Contacto("Silvia", "Hoferek", "silvia@upc.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c1);
        destinatarios.add(c2);
        destinatarios.add(c3);
        EmailManager em = new EmailManager();

        Email email1 = new Email("Reunion en la UCP","Se lo convoca el dia de la fecha para discutir el nuevo proyecto",c4,destinatarios);
        em.enviar(email1);

        Predicate<Email> predicadoPorAsunto = email -> email.getAsunto().contains("Reunion");
        Predicate<Email> predicadoPorPalabraClave = email -> email.getContenido().contains("nuevo proyecto");
        Predicate<Email> predicadoRemitente = email -> email.getRemitente().equals(c4);

        Predicate<Email> predicadoCombinado = predicadoPorAsunto.and(predicadoPorPalabraClave).and(predicadoRemitente);

        Filtro filtroCombinado = new Filtro("Filtro Combinado Asunto, Palabra Clave y Remitente", predicadoCombinado);

        List<Email> emailsFiltradosAugusto = filtroCombinado.buscarConFiltro(filtroCombinado, c2.bandeja.getRecibidos());
        List<Email> emailsFiltradosIvan = filtroCombinado.buscarConFiltro(filtroCombinado, c1.bandeja.getRecibidos());
        List<Email> emailsFiltradosRodrigo = filtroCombinado.buscarConFiltro(filtroCombinado, c3.bandeja.getRecibidos());

        assertEquals(1, emailsFiltradosAugusto.size());
        assertEquals(1, emailsFiltradosIvan.size());
        assertEquals(1, emailsFiltradosRodrigo.size());

        assertTrue(emailsFiltradosAugusto.get(0).getAsunto().contains("Reunion"));
        assertEquals("Filtro Combinado Asunto, Palabra Clave y Remitente", filtroCombinado.getNombre());

        assertTrue(emailsFiltradosIvan.get(0).getContenido().contains("nuevo proyecto"));
        assertTrue(emailsFiltradosRodrigo.get(0).getRemitente().equals(c4));

    }


    @Test
    public void mandar_email_a_grupo_creado(){

        Contacto c1 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c2 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");
        Contacto c4 = new Contacto("Silvia", "Hoferek", "silvia@upc.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c1);
        destinatarios.add(c2);
        destinatarios.add(c3);

        Email email1 = new Email("Reunion en la UCP","Se lo convoca el dia de la fecha para discutir el nuevo proyecto",c4,destinatarios);

        // Validaciones (simplemente podemos verificar el contenido del email)
        assertEquals("Reunion en la UCP", email1.getAsunto());
        
        assertEquals(c4, email1.getRemitente());
        assertTrue(destinatarios.contains(c1));
        assertTrue(destinatarios.contains(c2));
        assertTrue(destinatarios.contains(c3));

    }

    @Test
    public void mandar_email_a_grupo_precreado(){

        LosPibes lp = new LosPibes();
        Contacto c1 = new Contacto("Ramiro", "Oviedo", "ramiroviedo@gmail.com");

        EmailManager em = new EmailManager();
        Email email1 = new Email ("Vamos a jugar?", "Sale LOL", c1, lp.getContactos());
        em.enviar(email1);
        
        assertEquals("Vamos a jugar?", email1.getAsunto());
        assertEquals(c1, email1.getRemitente());
        assertEquals(4, lp.obtenerMiembros().size());
    }
    
}