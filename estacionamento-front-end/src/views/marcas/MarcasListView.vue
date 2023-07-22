<template>
  <div class="container">
    <div class="view-table-info">
      <div>
        <h1>Lista de marcas</h1>
      </div>
      <div class="cadastrar-button-box">
        <router-link to="/marcas/formulario" class="classic-button sucess-button">
          Cadastrar
        </router-link>
      </div>
    </div>
    <table class="view-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Ativo</th>
          <th>Nome</th>
          <th>Opções</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in marcasList" :key="item.id">
          <th>{{ item.id }}</th>
          <th>
            <span v-if="item.ativo" class="text-color-sucess">Ativo</span>
            <span v-if="!item.ativo" class="text-color-danger">Inativo</span>
          </th>
          <th>{{item.nome}}</th>
          <th>
            <div class="options-box">
              <router-link :to="{name: 'marcas-formulario-editar-view', 
              query: {id: item.id, form: 'editar'}}">
                <img src="../../assets/pencil-icon.svg" alt="Ícone de lápis" title="Editar">
              </router-link> 
              |
              <router-link :to="{name: 'marcas-formulario-excluir-view', 
              query: {id: item.id, form: 'excluir'}}">
                <img src="../../assets/trash-icon.svg" alt="Ícone de lixeira" title="Excluir">
              </router-link> 
            </div>
          </th>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts">

import { defineComponent } from 'vue';

import MarcaClient from '@/client/MarcaClient';
import { MarcaModel } from '@/model/MarcaModel';

export default defineComponent({
  name: 'MarcaLista',
  data() {
    return {
        marcasList: new Array<MarcaModel>()
    }
  },
  mounted() {
    this.findAll();
  },
  methods: {

    findAll() {
      MarcaClient.findAll()
        .then(sucess => {
          this.marcasList = sucess
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
});

</script>