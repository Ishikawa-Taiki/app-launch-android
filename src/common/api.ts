export async function requestWebAPI<R>(endpoint: string): Promise<R> {
  const response = await fetch(
    'https://script.google.com/macros/s/AKfycbzLNP_CPag82-Aw7r7QF8lQ2Y8kwBGjOVv_3BlZFXlflkYp5Bo/' +
      endpoint,
  );
  return response.json();
}
