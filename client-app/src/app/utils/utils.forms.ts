import { Injectable } from '@angular/core';

@Injectable()
export default class UtilsForms {
    static permitirApenasLetras(e: KeyboardEvent): void {
        const code = e.key.charCodeAt(0);
        if ((code >= 65 && code <= 90) || (code >= 97 && code <= 122)) {} else {
            e.preventDefault();
            return;
        }
    }
}
