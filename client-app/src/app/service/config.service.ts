export class ConfigService {
    private urlService: string;

    constructor() {
        this.urlService = 'http://localhost:8080/api/v1/desafio-solutis';
    }

    getUrlService(): string {
        return this.urlService;
    }
}
