import { AbstractEntity } from "./AbstractEntity";
import { Cor } from "./Cor";
import { Modelo } from "./Modelo";
import { Tipo } from "./Tipo";

export class Veiculo extends AbstractEntity {
  placa!: string;
  modelo!: Modelo;
  cor!: Cor;
  tipo!: Tipo;
  ano!: number;
}