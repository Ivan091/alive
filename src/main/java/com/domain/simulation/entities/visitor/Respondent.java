package com.domain.simulation.entities.visitor;

import com.domain.simulation.entities.Entity;

public interface Respondent<T> {

    T response(Entity entity);
}
