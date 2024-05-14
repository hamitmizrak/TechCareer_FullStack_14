//rfc => React Function Component.
//rcc => React Class Component.
//rsc => React Stateles Component (state olmayan).
import React from 'react';

//TR import edelim
//adı tr olsun
import tr from "../assets/flag/Turkish.png"
import en from "../assets/flag/English.png"

// Dil secenegi
import { withTranslation } from 'react-i18next';
import OtherLanguageServices from "./OtherLanguageServices";
import { Link } from 'react-router-dom';

// FUNCTION
function OtherLanguageReusability(props) {

    //Bayraklar
    const internationalizationLanguage = language => {
        // Object Destructing
        const { i18n } = props;

        //i18n
        i18n.changeLanguage(language);

        //Hem java tarafından hemde frontend tarafından değişiklik yaptık.
        OtherLanguageServices.headerLanguageServices(language);
    }

    //render
    return (
        <React.Fragment>
            <div className="hidden-arrow flex items-center whitespace-nowrap transition duration-150 ease-in-out motion-reduce:transition-none">
                {/* Dil */}
                <Link className="" onClick={() => internationalizationLanguage('tr')}>
                    <img loading="lazy" src={tr} className="relative rounded-full w-6 h-6 me-3 transition-all duration-300 cursor-pointer filter grayscale hover:grayscale-0" alt="TR" />
                </Link>

                {/* style={{ height: "1rem" }} */}
                <Link className="" onClick={() => internationalizationLanguage('en')}>
                    <img loading="lazy" src={en} className="relative rounded-full w-6 h-6 me-3 transition-all duration-300 cursor-pointer filter grayscale hover:grayscale-0" alt="EN" />
                </Link>
            </div>

        </React.Fragment>
    ); //end return
} //end function

// export default UserRegister
// Higher Order Component: monad componenti başka bir componentin içine  ekleyip oradanda yeni sonuclar elde etmek
export default withTranslation()(OtherLanguageReusability)

