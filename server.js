const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const PORT = 3001; // Choose any port you prefer

app.use(cors()); // Enable CORS
app.use(bodyParser.json()); // Parse JSON requests

// Function to determine the zodiac sign
const getZodiacSign = (month, day) => {
    const zodiacSigns = [
        { sign: 'Capricorn', end: 19 }, // January
        { sign: 'Aquarius', end: 18 },  // February
        { sign: 'Pisces', end: 20 },     // March
        { sign: 'Aries', end: 19 },      // April
        { sign: 'Taurus', end: 20 },     // May
        { sign: 'Gemini', end: 20 },     // June
        { sign: 'Cancer', end: 22 },     // July
        { sign: 'Leo', end: 22 },        // August
        { sign: 'Virgo', end: 22 },      // September
        { sign: 'Libra', end: 22 },      // October
        { sign: 'Scorpio', end: 21 },    // November
        { sign: 'Sagittarius', end: 21 } // December
    ];

    if (month < 1 || month > 12 || day < 1 || day > 31) {
        return 'Invalid date';
    }

    if (day > zodiacSigns[month - 1].end) {
        return zodiacSigns[month % 12].sign; // Get the next sign
    }

    return zodiacSigns[month - 1].sign; // Get the current sign
};

// Handle GET requests to the root URL
app.get('/', (req, res) => {
    res.send('Welcome to the Zodiac Sign Finder!');
});

// Handle POST requests to /zodiac-sign
app.post('/zodiac-sign', (req, res) => {
    const { month, day } = req.body;
    const sign = getZodiacSign(parseInt(month), parseInt(day));
    res.json({ sign }); // Send back the zodiac sign as a JSON response
});

// Start the server
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
