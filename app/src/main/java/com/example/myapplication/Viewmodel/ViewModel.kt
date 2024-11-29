package com.example.myapplication.Viewmodel

import com.example.myapplication.model.Pokemon

sealed interface PockUiState {
    data class Success(val pokemons: List<Pokemon>) : PockUiState
    object Error : PockUiState
    object Loading : PockUiState
}