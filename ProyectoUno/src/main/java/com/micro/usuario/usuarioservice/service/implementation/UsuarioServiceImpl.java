package com.micro.usuario.usuarioservice.service.implementation;

import com.micro.usuario.usuarioservice.entity.Calificacion;
import com.micro.usuario.usuarioservice.entity.CalificacionTrama;
import com.micro.usuario.usuarioservice.entity.Hotel;
import com.micro.usuario.usuarioservice.entity.Usuario;
import com.micro.usuario.usuarioservice.exceptions.ResourceNotFoundException;
import com.micro.usuario.usuarioservice.external.services.CalificacionServiceFeigth;
import com.micro.usuario.usuarioservice.external.services.HotelService;
import com.micro.usuario.usuarioservice.repository.UsuarioRepository;
import com.micro.usuario.usuarioservice.service.CalificacionService;
import com.micro.usuario.usuarioservice.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService, CalificacionService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CalificacionServiceFeigth calificacionServiceFeigth;



    @Override
    public Usuario saveUser(Usuario usuario) {
        String userRamdom = UUID.randomUUID().toString();
        usuario.setUsuarioId(userRamdom);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getUsers() {
        return usuarioRepository.findAll();
    }


    //RESTEMPLATE
  /*  @Override
    public Usuario getUsuario(String userId) {
        //En este método se comunicaran los dos microservicios con este

        //1. Obtenemos el usuario actual
        Usuario usuario = usuarioRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("Usuario no encontrado con el id: " + userId));

        //2. Con resttemplate, obtenemos la o las calificaciones en una arreglo
       Calificacion [] arregloCalificaciones = restTemplate.getForObject("http://CALIFICACION-SERVICE/calificaciones/usuarios/"+ usuario.getUsuarioId(), Calificacion[].class);

       //3. Ahora pasamos el arreglo a una lista para poder iterarla y modificar sus propiedades
       List<Calificacion> listaCalificaciones = Arrays.stream(arregloCalificaciones).collect(Collectors.toList());

       //4. Iteramos las calificaciones y vamos a setear el valor del hotel en la clase calificaciones y devolver el nuevo arreglo
        List<Calificacion> modificacionCalificaciones = listaCalificaciones.stream().map(calificacion -> {

            //1. Recibimos el hotel con un getForEntity
            ResponseEntity<Hotel> hoteles = restTemplate.getForEntity("http://HOTEL-SERVICE/hoteles/"+ calificacion.getHotelId(), Hotel.class);

            //2. Extraemos el body del ResponseEntity y lo guardamos en una variable de tipo Hotel
            Hotel hotel = hoteles.getBody();

            //3. Seteamos el valor del Hotel en la calificacion
            calificacion.setHotel(hotel);

            //4. Devolvemos el objeto nuevo de calificacion para que finalmente se unan todos en una lista
            return calificacion;
        }).collect(Collectors.toList());


        //5. Seteamos la lista obtenida anteriormente en la propiedad calificaciones de la clase usuario
        usuario.setCalificaciones(modificacionCalificaciones);

        //6. Devolvemos el usuario al cliente con toda la información
        return usuario;
    }*/



    //FEIGN
        @Override
    public Usuario getUsuario(String userId) {
        //En este método se comunicaran los dos microservicios con este

        //1. Obtenemos el usuario actual
        Usuario usuario = usuarioRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("Usuario no encontrado con el id: " + userId));

        //2. Con resttemplate, obtenemos la o las calificaciones en una arreglo
       Calificacion [] arregloCalificaciones = restTemplate.getForObject("http://CALIFICACION-SERVICE/calificaciones/usuarios/"+ usuario.getUsuarioId(), Calificacion[].class);

       //3. Ahora pasamos el arreglo a una lista para poder iterarla y modificar sus propiedades
       List<Calificacion> listaCalificaciones = Arrays.stream(arregloCalificaciones).collect(Collectors.toList());

       //4. Iteramos las calificaciones y vamos a setear el valor del hotel en la clase calificaciones y devolver el nuevo arreglo
        List<Calificacion> modificacionCalificaciones = listaCalificaciones.stream().map(calificacion -> {

            // SE APLICA LA BÚSQUEDA CON EL CLIENTE Feigh
            Hotel hotel = hotelService.getHotel(calificacion.getHotelId());

            calificacion.setHotel(hotel);

            return calificacion;
        }).collect(Collectors.toList());


        //5. Seteamos la lista obtenida anteriormente en la propiedad calificaciones de la clase usuario
        usuario.setCalificaciones(modificacionCalificaciones);

        //6. Devolvemos el usuario al cliente con toda la información
        return usuario;
    }


    @Override
    public CalificacionTrama guardarCalificacionTrama(CalificacionTrama calificacionTrama) {
        return calificacionServiceFeigth.guardarCalificacionFeiht(calificacionTrama);
    }
}
