import { AbstractEntity } from "./AbstractEntity";
import { MarcaModel } from "./MarcaModel";

export class Modelo extends AbstractEntity {
  nome!: string;
  marca!: MarcaModel;
}