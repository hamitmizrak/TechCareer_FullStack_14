// Axios
import axios from "axios";

// Language
class OtherLanguageServices {

    // language Flag button
    // accept-language= tr
    // accept-language= en
    headerLanguageServices(language) {
        axios.defaults.headers['accept-language'] = language;
    }

}//end class

// EXPORT
export default new OtherLanguageServices();