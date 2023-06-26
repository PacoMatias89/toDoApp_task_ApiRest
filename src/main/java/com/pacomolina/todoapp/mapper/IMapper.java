package com.pacomolina.todoapp.mapper;

/**
 *
 * Esta interfaz nos va a mapear la entrada a la salida.
 *
 * */

public interface IMapper <I, O>{
    public O map(I in);
}
