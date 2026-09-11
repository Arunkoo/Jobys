function App() {
  return (
    <main className="min-h-screen bg-background px-6 py-10 text-foreground sm:px-10">
      <div className="mx-auto flex min-h-[calc(100vh-5rem)] max-w-5xl flex-col justify-between rounded-3xl border bg-white/70 p-8 shadow-sm sm:p-12">
        <header className="flex items-center justify-between gap-6">
          <span className="text-sm font-bold uppercase tracking-[0.2em] text-primary">
            Jobys
          </span>
          <span className="rounded-full bg-muted px-3 py-1 text-xs font-semibold text-muted-foreground">
            Frontend ready
          </span>
        </header>
        <section className="max-w-2xl py-20">
          <p className="mb-5 text-sm font-semibold uppercase tracking-[0.18em] text-muted-foreground">
            Your next opportunity starts here
          </p>
          <h1 className="max-w-xl text-4xl font-black tracking-tight sm:text-6xl">
            A clear starting point for your job search.
          </h1>
          <p className="mt-6 max-w-lg text-lg leading-8 text-muted-foreground">
            The application workspace is ready for the pages and workflows we
            design next.
          </p>
        </section>
        <footer className="flex flex-wrap items-center justify-between gap-4 border-t pt-6 text-sm text-muted-foreground">
          <span>React + Vite + Tailwind CSS + shadcn/ui</span>
          <span>v0.1</span>
        </footer>
      </div>
    </main>
  );
}

export default App;
