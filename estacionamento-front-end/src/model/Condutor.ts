import { AbstractEntity } from "./AbstractEntity";

export class Condutor extends AbstractEntity {
  nome!: string;
  cpf!: string;
  tempoPago!: Date;
  tempoDesconto!: Date;
}