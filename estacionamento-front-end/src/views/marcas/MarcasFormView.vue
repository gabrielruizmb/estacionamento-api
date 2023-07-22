<template>
  <div class="container">
    <h1 v-if="form === undefined">Cadastrar nova marca</h1>
    <h1 v-if="form === 'editar'">Editar marca</h1>
    <h1 v-if="form === 'excluir'">Excluir marca</h1>
    <form action="" class="view-table view-form">
      <label for="">Nome da marca:</label>
      <br>
      <input type="text" v-model="marca.nome">
      <div v-if="form === 'editar'" class="change-status-field">
        <label for="">Ativar/Desativar:</label>
        <div class="status-switch">
          <span v-if="marca.ativo == true" class="text-color-sucess list-style-type">
            Ativo
          </span>
          <span v-if="marca.ativo == false" class="text-color-danger list-style-type">
            Inativo
          </span>
          <div v-if="marca.ativo == true" class="switch-status interruptor-switch-on" @click="onClickSwitchInterruptor()">
            <div class="switch-status-interruptor"></div>
          </div>
          <div v-if="marca.ativo == false" class="switch-status interruptor-switch-off" @click="onClickSwitchInterruptor()">
            <div class="switch-status-interruptor"></div>
          </div>
        </div>
      </div>
      <div class="form-view-buttons">
        <router-link to="/marcas/lista" class="classic-button info-button">
          Voltar
        </router-link> 
        <a v-if="form === undefined" 
        @click="onClickCadastrar()" 
        class="classic-button sucess-button">
          Cadastrar
        </a>
        <a v-if="form === 'editar'" 
        @click="onClickEditar()" 
        class="classic-button sucess-button">
          Editar
        </a>
        <a v-if="form === 'excluir'" 
        @click="onClickExcluir()" 
        class="classic-button danger-button">
          Excluir
        </a>
      </div>
    </form>
  </div>
</template>

<script lang="ts">

import { MarcaModel } from '@/model/MarcaModel';
import MarcaClient from '@/client/MarcaClient';
import { DefineComponent, defineComponent } from 'vue';

export default defineComponent({

  name: 'MarcaFormulario',
  data() {
    return {
      marca: new MarcaModel()
    }
  },
  computed: {
    id() {
      return this.$route.query.id;
    },
    form () {
      return this.$route.query.form;
    }
  },
  mounted() {
    if(this.id !== undefined) {
      this.findById(Number(this.id));
    }
  },
  methods: {
    onClickSwitchInterruptor() {
      this.marca.ativo == true ?
        this.marca.ativo = false :
        this.marca.ativo = true
    },
    onClickCadastrar() {
      MarcaClient.cadastrar(this.marca)
        .then (sucess => {

          this.marca = new MarcaModel();
          console.log(sucess)
        })
        .catch (error => {
          console.log(error.nome);
        })
    },
    findById(id: number) {
      MarcaClient.findById(id)
        .then(sucess => {
          this.marca = sucess;
        })
        .catch(error => {
         console.log(error);
        })
    },
    onClickEditar() {
      MarcaClient.editar(this.marca.id, this.marca)
        .then(sucess => {
          this.marca = new MarcaModel();
        })
        .catch(error => {
          console.log(error);
        })
    },
    onClickExcluir() {
      MarcaClient.excluir(this.marca.id)
        .then(sucess => {
          this.marca = new MarcaModel();
        })
        .catch(error => {
          console.log(error);
        })
    }
  }
});
</script>