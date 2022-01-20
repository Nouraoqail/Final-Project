 import "../StyleSheets/Header2.css"
 function Header2() {
      return (
  
        <div className="patterns">
          <svg width="100%" height="300px">
            <defs>
              <pattern id="polka-dots" x={0} y={0} width={100} height={100} patternUnits="userSpaceOnUse">
                <circle fill="#be9ddf" cx={25} cy={25} r={3} />
              </pattern>  
              <style dangerouslySetInnerHTML={{__html: "\n     @import url(\"https://fonts.googleapis.com/css?  family=Lora:400,400i,700,700i\");\n   " }} />
            </defs>
            <rect x={0} y={0} width="100%" height="100%" fill="url(#polka-dots)"> </rect>
            <text x="50%" y="60%" textAnchor="middle">
              Borrow it
            </text>
          </svg>
        </div>
      );
    }
export default Header2;
