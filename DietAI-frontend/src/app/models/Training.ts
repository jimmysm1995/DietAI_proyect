import { User } from "./User";

export class Training {
    name: string = '';
    typeTraining?: string; // Aquí puedes usar un tipo enum si lo prefieres
    difficulty?: number;
    days?: number;
    distribution?: string;
    usuarios?: User[];
}