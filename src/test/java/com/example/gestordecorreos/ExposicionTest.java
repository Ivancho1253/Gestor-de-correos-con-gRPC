package com.example.gestordecorreos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class ExposicionTest {
    
    //-----------------------------------Tests Seleccionados para Presentar------------------------------------------------------------//
    
    //Nro 1 = Se crea el contacto
    @Test
    public void crear_contacto_valido1() {
       Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");

       assertEquals("Augusto",c1.getNombre());
       assertEquals("Ojeda", c1.getApellido());
       assertEquals("augustom@gmail.com", c1.getCorreo());

    }

    //Nro 2 = Se intenta crear el contacto con un email invalido
    @Test
    public void crear_contacto_invalido2() {

        assertThrows(IllegalArgumentException.class, () -> {
            Contacto c1 = new Contacto("Rodrigo", "Magallanes", "rodrigmail.com");
        });

    }
    
    //Nro 3 = Envia el email
    @Test
    public void Mandar_Un_Email_Test3() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Hola","Como estas ivan?",c1 , destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(email1);

        assertEquals("Hola", email1.getAsunto());

        assertEquals(1, c2.bandeja.recibidos.size());
        assertEquals(1, c1.bandeja.enviados.size());
        
    }

    //Nro 4 = Se intenta mandar un email invalido
    @Test 
    public void Intentar_mandar_Un_Email_invalido_Test4() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("", "Vamos a la casa de joaco?", c1, destinatarios);

        EmailManager em = new EmailManager();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            em.enviar(email1);
        });

        // Verificar el mensaje de la excepción
        assertEquals("El correo debe tener un asunto.", exception.getMessage());
    }
    
    //Nro 5 = Filtro comun por remitente
    @Test
    public void filtrar_email_por_remitente_test5() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        List<Contacto> destinatarios1 = new ArrayList<>();
        destinatarios1.add(c3);
        
        EmailManager em = new EmailManager();
        Filtro filtro= new Filtro();
        for (int i = 0; i < 3; i++) {

            Email email1 = new Email("Hola Rodri","Nos vemos el finde?",c2, destinatarios1); //Ivan le manda a Rodri
            em.enviar(email1);
        }

        for (int i = 0; i < 3; i++) {

            Email email2 = new Email("Hola Rodri","Terminaste el codigo?",c1, destinatarios1); //Augusto le manda a rodri
            em.enviar(email2);
        }

        //Se guarda en una lis
        List <Email> listaFiltrada = filtro.filtrarPorRemitente(c1 , c3.bandeja.getRecibidos());

        assertEquals(3, listaFiltrada.size());
        
    }
    
    //Nro 6 = Filtro para ver mi bandeja y buscar el correo que quiero
    @Test
    public void filtrar_usuario_puede_buscar_correos_bandeja_entrada_borar_test6() {
        
        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c3);

        EmailManager em = new EmailManager();
        Filtro filtro= new Filtro();


            Email email1 = new Email("Hola rodri","Que sale este finde",c1, destinatarios);
            em.enviar(email1);

            Email email2 = new Email("Que onda","Rodri @#*",c2, destinatarios);
            em.enviar(email2);

            Email email3 = new Email("Hola","Me pasas el tp2?",c2, destinatarios);
            em.enviar(email3);

            Email email4 = new Email("Que onda me ayudas?","Tengo una duda con AM",c1, destinatarios);
            em.enviar(email4);

            //Entro a mi bandeja y veo mis correos
            assertEquals(4, c3.bandeja.getRecibidos().size());

            //Busco por palabra clave
            List<Email> filtradosPalabrasClaves = filtro.filtrarPorPalabrasClaves("finde", c3.bandeja.getRecibidos());
            assertEquals(1,filtradosPalabrasClaves.size());

            //Busco por asunto
            List<Email> filtradosAsuntos = filtro.filtrarPorAsunto("Hola", c3.bandeja.getRecibidos());
            assertEquals(2,filtradosAsuntos.size());

            //Busco por quien me envio
            assertEquals(2, filtro.filtrarPorRemitente(c1 , c3.bandeja.getRecibidos()).size());
            assertEquals(2, filtro.filtrarPorRemitente(c2 , c3.bandeja.getRecibidos()).size());

            List<Email> filtradosAugusto = filtro.filtrarPorRemitente(c1, c3.bandeja.getRecibidos());

            assertEquals(2,filtradosAugusto.size());

            //Borro mis emails de augusto
            em.borrar(filtradosAugusto);
            assertEquals(2, c3.bandeja.getRecibidos().size());
    }
    
    //Nro 7 = Primer Filtro complejo
    @Test
    public void filtrar_email_filtroCombinado_Asunto_PalabraClave_Remitente7() {

        Contacto c1 = new Contacto("Silvia", "Hoferek", "silvia@ucp.com");
        Contacto c2 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Reunion en la UCP","Se lo convoca el dia de la fecha para discutir el nuevo proyecto.", c1, destinatarios);

        EmailManager em = new EmailManager();
        Filtro filtro= new Filtro();

        em.enviar(email1);

        for (int i = 1; i < 6; i++){
            Email email2 = new Email("Consulta clase", "Por que falto a la clase del dia de la fecha " + i,  c1, destinatarios);
            em.enviar(email2);
        }

        Predicate<Email> predicadoPorAsunto = email -> email.getAsunto().contains("Reunion");
        Predicate<Email> predicadoPorPalabraClave = email -> email.getContenido().contains("proyecto");
        Predicate<Email> predicadoRemitente = email -> email.getRemitente().equals(c1);


        Predicate<Email> predicadoCombinado = predicadoPorAsunto.and(predicadoPorPalabraClave).and(predicadoRemitente);

        Filtro filtroCombinado = new Filtro("Filtro Combinado Asunto,Palabra Clave y Remitente", predicadoCombinado);

        List<Email> emailsFiltrados = filtro.buscarConFiltro(filtroCombinado, c2.bandeja.getRecibidos());

        assertEquals(1, emailsFiltrados.size());

        assertTrue(emailsFiltrados.get(0).getAsunto().contains("Reunion"));
        assertEquals("Filtro Combinado Asunto,Palabra Clave y Remitente", filtroCombinado.getNombre());

        assertTrue(emailsFiltrados.get(0).getContenido().contains("proyecto"));
        assertTrue(emailsFiltrados.get(0).getRemitente().equals(c1));

    }

    //Nro 8 = Segundo Filtro complejo
    @Test
    public void filtrar_email_filtrarCombinado_asunto_destinatario_palabraClave8() {
        
        Contacto c1 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c2 = new Contacto("Jose", "Fernandez", "jose@ucp.com");
        Contacto c3 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        EmailManager em = new EmailManager();
        Filtro filtro= new Filtro();
        for (int i = 1; i < 6; i++){
            Email email1 = new Email("TP2", "Que se dio en la clase de fecha " + i,  c1, destinatarios);
            em.enviar(email1);
        }

        for (int i = 1; i < 6; i++){
            Email email2 = new Email("Ausente", "Falte a la clase de fecha " + i,  c3, destinatarios);
            em.enviar(email2);
        }


        Predicate<Email> predicadoPorAsunto = email -> email.getAsunto().contains("TP2");
        Predicate<Email> predicadoPorPalabraClave = email -> email.getContenido().contains("Que se dio en la clase de fecha 2");
        Predicate<Email> predicadoRemitente = email -> email.getRemitente().equals(c1);


        Predicate<Email> predicadoCombinado = predicadoPorAsunto.and(predicadoPorPalabraClave).and(predicadoRemitente);

        Filtro filtroCombinado = new Filtro("Filtro Combinado Asunto, Palabra Clave y Remitente", predicadoCombinado);

        List<Email> emailsFiltrados = filtro.buscarConFiltro(filtroCombinado, c2.bandeja.getRecibidos());

        assertEquals(1, emailsFiltrados.size());

        assertTrue(emailsFiltrados.get(0).getAsunto().contains("TP2"));
        assertEquals("Filtro Combinado Asunto, Palabra Clave y Remitente", filtroCombinado.getNombre());

        assertTrue(emailsFiltrados.get(0).getContenido().contains("Que se dio en la clase de fecha 2"));
        assertTrue(emailsFiltrados.get(0).getRemitente().equals(c1));

    }

    //Nro 9 = Se crea un grupo para mandar el email
    @Test
    public void verificar_filtro_complejo_en_multiples_bandejas9(){

        Contacto c1 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c2 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");
        Contacto c4 = new Contacto("Silvia", "Hoferek", "silvia@ucp.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c1);
        destinatarios.add(c2);
        destinatarios.add(c3);
        
        EmailManager em = new EmailManager();
        Filtro filtro = new Filtro();

        Email email1 = new Email("Reunion en la UCP","Se lo convoca el dia de la fecha para discutir el nuevo proyecto",c4,destinatarios);
        em.enviar(email1);

        Predicate<Email> predicadoPorAsunto = email -> email.getAsunto().contains("Reunion");
        Predicate<Email> predicadoPorPalabraClave = email -> email.getContenido().contains("nuevo proyecto");
        Predicate<Email> predicadoRemitente = email -> email.getRemitente().equals(c4);

        Predicate<Email> predicadoCombinado = predicadoPorAsunto.and(predicadoPorPalabraClave).and(predicadoRemitente);

        Filtro filtroCombinado = new Filtro("Filtro Combinado Asunto, Palabra Clave y Remitente", predicadoCombinado);

        List<Email> emailsFiltradosAugusto = filtro.buscarConFiltro(filtroCombinado, c2.bandeja.getRecibidos());
        List<Email> emailsFiltradosIvan = filtro.buscarConFiltro(filtroCombinado, c1.bandeja.getRecibidos());
        List<Email> emailsFiltradosRodrigo = filtro.buscarConFiltro(filtroCombinado, c3.bandeja.getRecibidos());


        assertEquals(1, emailsFiltradosAugusto.size());
        assertEquals(1, emailsFiltradosIvan.size());
        assertEquals(1, emailsFiltradosRodrigo.size());

        assertTrue(emailsFiltradosAugusto.get(0).getAsunto().contains("Reunion"));
        assertEquals("Filtro Combinado Asunto, Palabra Clave y Remitente", filtroCombinado.getNombre());

        assertTrue(emailsFiltradosIvan.get(0).getContenido().contains("nuevo proyecto"));
        assertTrue(emailsFiltradosRodrigo.get(0).getRemitente().equals(c4));

    }
    
    //Nro 10 = Se manda un email a un grupo ya creado
   @Test
    public void mandar_email_a_grupo10(){

        LosPibes lp = new LosPibes();
        Contacto c1 = new Contacto("Ramiro", "Oviedo", "ramiroviedo@gmail.com");

        EmailManager em = new EmailManager();
        Email email1 = new Email ("Vamos a jugar?", "Sale LOL", c1, lp.getContactos());
        em.enviar(email1);
        
        assertEquals("Vamos a jugar?", email1.getAsunto());
        assertEquals(c1, email1.getRemitente());
        assertEquals(4, lp.obtenerMiembros().size());
        
        
        for (Contacto contacto : lp.obtenerMiembros()) { 
           assertEquals(1, contacto.bandeja.recibidos.size());
        }
        
        assertEquals(4, lp.obtenerEmailsRecibidos().size());

    }

    @Test
    public void Test_Clonar() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Hola","Como estas ivan?",c1 , destinatarios);

        EmailManager em = new EmailManager();
        Filtro filtro = new Filtro();
        
        var email2 = email1.clonar();
        em.enviar(email2);

        assertEquals(1, c2.bandeja.recibidos.size());
        assertEquals(1, c1.bandeja.enviados.size());

        List<Email> filtradosAugusto = filtro.filtrarPorRemitente(c1, c2.bandeja.getRecibidos());

        assertEquals(1,filtradosAugusto.size());

        //Borro mis emails de augusto
        em.borrar(filtradosAugusto);

        assertEquals(0, c2.bandeja.recibidos.size());
        assertEquals(1, c1.bandeja.enviados.size());

        assertEquals(email1.getAsunto(), email2.getAsunto());
        assertEquals(email1.getContenido(), email2.getContenido());
        assertEquals(email1.getRemitente(), email2.getRemitente());
        assertEquals(email1.getDestinatarios(), email2.getDestinatarios());

    }

    @Test
    public void verificar_filtro_complejo_en_multiples_bandejas_con_Clon(){

        Contacto c1 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c2 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");
        Contacto c4 = new Contacto("Silvia", "Hoferek", "silvia@ucp.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c1);
        destinatarios.add(c2);
        destinatarios.add(c3);
        
        EmailManager em = new EmailManager();
        Filtro filtro = new Filtro();

        Email email1 = new Email("Reunion en la UCP","Se lo convoca el dia de la fecha para discutir el nuevo proyecto",c4,destinatarios);
        var email2 = email1.clonar();
        em.enviar(email2);
        
        Predicate<Email> predicadoPorAsunto = email -> email.getAsunto().contains("Reunion");
        Predicate<Email> predicadoPorPalabraClave = email -> email.getContenido().contains("nuevo proyecto");
        Predicate<Email> predicadoRemitente = email -> email.getRemitente().equals(c4);

        Predicate<Email> predicadoCombinado = predicadoPorAsunto.and(predicadoPorPalabraClave).and(predicadoRemitente);

        Filtro filtroCombinado = new Filtro("Filtro Combinado Asunto, Palabra Clave y Remitente", predicadoCombinado);

        List<Email> emailsFiltradosAugusto = filtro.buscarConFiltro(filtroCombinado, c2.bandeja.getRecibidos());
        List<Email> emailsFiltradosIvan = filtro.buscarConFiltro(filtroCombinado, c1.bandeja.getRecibidos());
        List<Email> emailsFiltradosRodrigo = filtro.buscarConFiltro(filtroCombinado, c3.bandeja.getRecibidos());

        assertEquals(1, emailsFiltradosAugusto.size());
        assertEquals(1, emailsFiltradosIvan.size());
        assertEquals(1, emailsFiltradosRodrigo.size());

        assertTrue(emailsFiltradosAugusto.get(0).getAsunto().contains("Reunion"));
        assertEquals("Filtro Combinado Asunto, Palabra Clave y Remitente", filtroCombinado.getNombre());

        assertTrue(emailsFiltradosIvan.get(0).getContenido().contains("nuevo proyecto"));
        assertTrue(emailsFiltradosRodrigo.get(0).getRemitente().equals(c4));

        assertEquals(1, c2.bandeja.recibidos.size());
        assertEquals(1, c1.bandeja.recibidos.size());
        assertEquals(1, c3.bandeja.recibidos.size());

        assertEquals(email1.getAsunto(), email2.getAsunto());

        assertEquals(email1.getContenido(), email2.getContenido());
        assertEquals(email1.getRemitente(), email2.getRemitente());
        assertEquals(email1.getDestinatarios(), email2.getDestinatarios());



    }

    @Test
    public void Test_asunto() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustom@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c3 = new Contacto("Ivannn","Cabrera", "ivangonzalo1253@gmail.com");
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);
        destinatarios.add(c3);

        Email email1 = new Email("Hola","Como estas ivan?",c1 , destinatarios);

        EmailManager em = new EmailManager();
        Filtro filtro = new Filtro();
        
        em.enviar(email1);

        assertEquals(1, c2.bandeja.recibidos.size());
        assertEquals(1, c1.bandeja.enviados.size());

        List<Email> filtradosAugusto = filtro.filtrarPorRemitente(c1, c2.bandeja.getRecibidos());

        assertEquals(1,filtradosAugusto.size());

        assertEquals(1, c2.bandeja.recibidos.size());
        assertEquals(1, c3.bandeja.recibidos.size());
        assertEquals(1, c1.bandeja.enviados.size());

        var emailRecibidosC2 = c2.bandeja.getRecibidos().get(0);
        emailRecibidosC2.setAsunto("APROBADO");

        assertEquals("Hola", c1.bandeja.enviados.get(0).getAsunto());
        assertEquals("APROBADO", c2.bandeja.recibidos.get(0).getAsunto());
        assertEquals("Hola", c3.bandeja.recibidos.get(0).getAsunto());
    }
}
