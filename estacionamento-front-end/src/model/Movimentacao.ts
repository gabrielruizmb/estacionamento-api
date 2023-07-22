import { AbstractEntity } from "./AbstractEntity";
import { Condutor } from "./Condutor";
import { Veiculo } from "./Veiculo";

export class Movimentacao extends AbstractEntity {
  veiculo!: Veiculo;
  condutor!: Condutor;
  entrada!: Date;
  saida!: Date;
  tempo!: Date;
  tempoDesconto!: Date;
  tempoMulta!: Date;
  valorDesconto!: number;
  valorMulta!: number;
  valorHora!: number;
  valorTotal!: number;
  valorHoraMulta!: number;
}