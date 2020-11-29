package com.group12.service;
/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 02-09-2020
 *   Description: An Implementation of a general Interface Service
 */

public interface IService <EntityType,ID> {
    EntityType create(EntityType t);
    EntityType read(ID id);
    EntityType update(EntityType t);
    boolean delete (ID id);


}

