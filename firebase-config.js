function envOrDefault(viteKey, fallback) {
  const val = import.meta.env?.[viteKey];
  if (val && val !== 'undefined' && val !== 'null') return val;
  return fallback;
}

export const firebaseConfig = {
  apiKey:            envOrDefault('VITE_FIREBASE_API_KEY',             'AIzaSyCU5RsQm8nkwyomMDTFJEsyzAIzaxM_ygM'),
  authDomain:        envOrDefault('VITE_FIREBASE_AUTH_DOMAIN',         'po-bid.firebaseapp.com'),
  databaseURL:       envOrDefault('VITE_FIREBASE_DATABASE_URL',        'https://po-bid-default-rtdb.firebaseio.com'),
  projectId:         envOrDefault('VITE_FIREBASE_PROJECT_ID',          'po-bid'),
  storageBucket:     envOrDefault('VITE_FIREBASE_STORAGE_BUCKET',      'po-bid.firebasestorage.app'),
  messagingSenderId: envOrDefault('VITE_FIREBASE_MESSAGING_SENDER_ID', '511658961861'),
  appId:             envOrDefault('VITE_FIREBASE_APP_ID',              '1:511658961861:web:5125a35813babbb0c179ac'),
  measurementId:     envOrDefault('VITE_FIREBASE_MEASUREMENT_ID',      'G-0FTQVWG0B9'),
};

export const firebaseAppName = 'po-bid-app';

export const RENT_TRACKER_PATH = 'rentTracker/houses';
