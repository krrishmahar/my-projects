from google.cloud import translate_v2 as google_translate
from flask_babel import _
from app import app
    
def translate(text, source_language, dest_language):
    if 'GOOGLE_APPLICATION_CREDENTIALS' not in app.config or \
            not app.config['GOOGLE_APPLICATION_CREDENTIALS']:
        return 'Error: the translation service is not configured.'
    
    translate_client = google_translate.Client()

    try:
        result = translate_client.translate(
            text, source_language=source_language, target_language=dest_language)
    except Exception as e:
        return f'Error: the translation service failed. {str(e)}'

    return result['translatedText']