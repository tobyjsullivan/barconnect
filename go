#!/bin/bash

if [ "$1" = "again" ]
then ant clean compile jar run
else ant compile jar run
fi

