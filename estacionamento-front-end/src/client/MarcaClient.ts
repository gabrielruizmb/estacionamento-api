import { MarcaModel } from "@/model/MarcaModel";
import axios, {AxiosInstance} from "axios";

export class MarcaClient {
  private axiosClient: AxiosInstance;

  constructor() {
    this.axiosClient = axios.create({
      baseURL: 'http://localhost:8080/api/marca',
      headers: {'Content-Type' : 'application/json'}
    });
  }

  public async findById(id: number) : Promise<MarcaModel> {
    try {
      return (await this.axiosClient.get<MarcaModel>(`/${id}`)).data
    }
    catch (error: any) {
      return Promise.reject(error.reponse)
    }
  }

  public async findAll(): Promise<MarcaModel[]> {
    try {
      return (await this.axiosClient.get<MarcaModel[]>(`/lista`)).data
    }
    catch(error: any) {
      return Promise.reject(error.reponse)
    }
  }

  public async cadastrar(marca: MarcaModel): Promise<any> {
    try {
        return (await this.axiosClient.post<string>(``, marca)).data
    } catch (error:any) {
        return Promise.reject(error.response.data)
    }
  }
  public async editar(id: number, marca: MarcaModel): Promise<string> {
    try {
        return (await this.axiosClient.put<string>(`/${id}`, marca)).data
    } catch (error:any) {
        return Promise.reject(error.response)
    }
  }
  public async excluir(id: number): Promise<string> {
    try {
        return (await this.axiosClient.delete<string>(`/${id}`)).data
    } catch (error:any) {
        return Promise.reject(error.response)
    }
  }
}

export default new MarcaClient();
