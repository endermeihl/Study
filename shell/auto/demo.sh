#!/bin/bash

log(){
    Date=$(date +%Y-%m-%d-%T)
    echo "${Date}"-"$1"
}
log "who"