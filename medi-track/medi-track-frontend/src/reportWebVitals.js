// Importing required functions from the 'web-vitals' library
import { onCLS, onFID, onFCP, onLCP, onTTFB } from 'web-vitals';

// Exporting the `reportWebVitals` function
const reportWebVitals = (onPerfEntry) => {
  if (onPerfEntry && onPerfEntry instanceof Function) {
    // Registering performance metrics handlers
    onCLS(onPerfEntry);
    onFID(onPerfEntry);
    onFCP(onPerfEntry);
    onLCP(onPerfEntry);
    onTTFB(onPerfEntry); // Corrected to use `onTTFB`
  }
};

export default reportWebVitals;
